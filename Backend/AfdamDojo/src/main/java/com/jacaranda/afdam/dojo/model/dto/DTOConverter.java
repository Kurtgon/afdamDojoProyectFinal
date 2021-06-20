package com.jacaranda.afdam.dojo.model.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jacaranda.afdam.dojo.model.entity.Alergia;
import com.jacaranda.afdam.dojo.model.entity.Alumno;
import com.jacaranda.afdam.dojo.model.entity.Profesor;
import com.jacaranda.afdam.dojo.model.entity.enums.Disciplinas;
import com.jacaranda.afdam.dojo.model.repo.AlergiaRepository;

@Component
public class DTOConverter {

	@Autowired
	private AlergiaRepository alergiaRepository;

	// Creamos el método para convertir de un alumno a un dto
	public Alumno fromAlumnoDTOToAlumno(AlumnoDTO dto) {
		// Creamos un alumno
		Alumno alumno = new Alumno();
		
		//Alumno alumno = new Alumno(dto.getContact(), Disciplinas.valueOf(dto.getDiscipline()), null );

		// Nos creamos el Set de Allergy
		Alergia alergia = alergiaRepository.findAlergiaByAlergyName(dto.getAllergy());
		Set<Alergia> allergys = new HashSet<Alergia>();
		allergys.add(alergia);

		// Setamos los atributos del alumno para convertir
		alumno.setName(dto.getName());
		alumno.setSurnames(dto.getSurnames());
		alumno.setBirthdate(dto.getBirthdate());
		alumno.setCurp(dto.getCurp());
		alumno.setTlf(dto.getTlf());
		alumno.setAddress(dto.getAddress());
		alumno.setEmail(dto.getEmail());
		alumno.setPicture(dto.getPicture());
		alumno.setContact(dto.getContact());
		alumno.setDiscipline(Disciplinas.valueOf(dto.getDiscipline()));
		alumno.setAllergy(allergys);

		return alumno;
	}

	// Creamos el método para convetir de un dto a un Alumno
	public AlumnoDTO fromAlumnoToAlumnoDTO(Alumno alumno) {

		// Creamos un AlumnoDTO
		AlumnoDTO dto = new AlumnoDTO();

		// Pasamos la colección a un string
		StringBuilder allergysBuilder = new StringBuilder();
		for (Alergia allergy : alumno.getAllergy()) {
			allergysBuilder.append(allergy.getAlergyName()).append(" ");
		}

		// Setamos los atributos del AlumnoDTO a convertir
		dto.setName(alumno.getName());
		dto.setSurnames(alumno.getSurnames());
		dto.setBirthdate(alumno.getBirthdate());
		dto.setCurp(alumno.getCurp());
		dto.setTlf(alumno.getTlf());
		dto.setAddress(alumno.getAddress());
		dto.setEmail(alumno.getEmail());
		dto.setPicture(alumno.getPicture());
		dto.setContact(alumno.getContact());
		if(alumno.getDiscipline() == null) {
			dto.setDiscipline(null);
		}else {
			dto.setDiscipline(alumno.getDiscipline().name());
		}
		dto.setAllergy(allergysBuilder.toString());

		return dto;
	}
	
	// Creamos el método para convertir de un profesor a un dto
	public Profesor fromProfesorDTOToProfesor(ProfesorDTO dto) {
		
		Profesor profesor = new Profesor();
		
		profesor.setName(dto.getName());
		profesor.setSurnames(dto.getSurnames());
		profesor.setBirthdate(dto.getBirthdate());
		profesor.setCurp(dto.getCurp());
		profesor.setTlf(dto.getTlf());
		profesor.setAddress(dto.getAddress());
		profesor.setEmail(dto.getEmail());
		profesor.setPicture(dto.getPicture());
		
		return profesor;
		
	}
	
	// Creamos el método para convetir de un dto a un profesor
	public ProfesorDTO fromProfesorToProfesorDTO(Profesor profesor) {
		
		ProfesorDTO dto = new ProfesorDTO();
		
		dto.setName(profesor.getName());
		dto.setSurnames(profesor.getSurnames());
		dto.setBirthdate(profesor.getBirthdate());
		dto.setCurp(profesor.getCurp());
		dto.setTlf(profesor.getTlf());
		dto.setAddress(profesor.getAddress());
		dto.setEmail(profesor.getEmail());
		dto.setPicture(profesor.getPicture());
		
		return dto;
	}
	
}
