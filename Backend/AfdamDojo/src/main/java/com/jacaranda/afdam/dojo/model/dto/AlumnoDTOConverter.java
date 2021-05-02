package com.jacaranda.afdam.dojo.model.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jacaranda.afdam.dojo.model.entity.Alergia;
import com.jacaranda.afdam.dojo.model.entity.Alumno;
import com.jacaranda.afdam.dojo.model.entity.enums.Disciplinas;
import com.jacaranda.afdam.dojo.model.repo.AlergiaRepository;

@Component
public class AlumnoDTOConverter {

	@Autowired
	private AlergiaRepository alergiaRepository;

	// Creamos el método para convertir de un alumno a un dto
	public Alumno fromAlumnoDTOToAlumno(AlumnoDTO dto) {
		// Creamos un alumno
		Alumno alumno = new Alumno();

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
		dto.setDiscipline(alumno.getDiscipline().name());
		dto.setAllergy(allergysBuilder.toString());

		return dto;
	}
}
