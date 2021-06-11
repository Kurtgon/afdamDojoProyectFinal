package com.jacaranda.afdam.dojo.model.service;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.afdam.dojo.model.dto.AlumnoDTO;
import com.jacaranda.afdam.dojo.model.dto.DTOConverter;
import com.jacaranda.afdam.dojo.model.entity.Alergia;
import com.jacaranda.afdam.dojo.model.entity.Alumno;
import com.jacaranda.afdam.dojo.model.entity.enums.Disciplinas;
import com.jacaranda.afdam.dojo.model.exceptions.AlumnoException;
import com.jacaranda.afdam.dojo.model.repo.AlergiaRepository;
import com.jacaranda.afdam.dojo.model.repo.AlumnoRepository;

@Service("alumnoService")
public class AlumnoService {

	// Inyectamos el repositorio de Alumnos
	@Autowired
	private AlumnoRepository alumnoRepo;
	
	// Inyectamos el repositorio de alergias
	@Autowired
	private AlergiaRepository alergiaRepository;

	// Inyectamos el converter de Alumnos
	@Autowired
	private DTOConverter alumnoConverter;

	// Obtener todos los alumnos
	public List<AlumnoDTO> getAlumnos() throws AlumnoException {

		List<Alumno> alumnos = (List<Alumno>) alumnoRepo.findAll();

		if (alumnos.size() == 0) {

			throw new AlumnoException("No existen alumnos");
		}
		
		List<AlumnoDTO> dto = new ArrayList<AlumnoDTO>();
		
		for (Alumno alumno : alumnos) {

			dto.add(alumnoConverter.fromAlumnoToAlumnoDTO(alumno));
		}
		return dto;
	}
	
	// Obtener un alumno
	public AlumnoDTO getAlumno(String curp) throws AlumnoException {
		
		Alumno alumno = alumnoRepo.findAlumnoByCurp(curp);
		
		if (alumno == null) {
			
			throw new AlumnoException("No existe el alumno");
		}
		
		AlumnoDTO dto = alumnoConverter.fromAlumnoToAlumnoDTO(alumno);
		
		return dto;
	}

	
	// Modificar un alumno
	public AlumnoDTO upDateAlumno(String curp, AlumnoDTO dtoSent) throws AlumnoException {
		
		Alumno alumno = alumnoRepo.findAlumnoByCurp(curp);
		
		if (alumno == null) {
			
			throw new AlumnoException("Error no se puede actualizar, el alumno no existe");
		}
		
		upAlumno(alumno,dtoSent);
		
		alumnoRepo.save(alumno);
		
		return alumnoConverter.fromAlumnoToAlumnoDTO(alumno); 
		
	}
	
	private void upAlumno(Alumno origin, AlumnoDTO sent) {
		
		origin.setName((sent.getName() == null) ? origin.getName() : sent.getName());
		origin.setSurnames((sent.getSurnames() == null) ? origin.getSurnames() : sent.getSurnames());
		origin.setBirthdate((sent.getBirthdate() == null) ? origin.getBirthdate() : sent.getBirthdate());
		origin.setTlf((sent.getTlf() == null) ? origin.getTlf() : sent.getTlf());
		origin.setAddress((sent.getAddress() == null) ? origin.getAddress() : sent.getAddress());
		origin.setEmail((sent.getEmail() == null) ? origin.getEmail() : sent.getEmail());
		origin.setPicture((sent.getPicture() == null) ? origin.getPicture() : sent.getPicture());
		origin.setContact((sent.getContact() == null) ? origin.getContact() : sent.getContact());
		
		Disciplinas disciplina = Disciplinas.valueOf(sent.getDiscipline());
		origin.setDiscipline((sent.getDiscipline() == null) ? origin.getDiscipline() : disciplina);
		
		Alergia alergia = alergiaRepository.findAlergiaByAlergyName(sent.getAllergy());
		Set<Alergia> allergys = new HashSet<Alergia>();
		allergys.add(alergia);
		
		origin.setAllergy((sent.getAllergy() == null) ? origin.getAllergy() : allergys);
		
	}
}


