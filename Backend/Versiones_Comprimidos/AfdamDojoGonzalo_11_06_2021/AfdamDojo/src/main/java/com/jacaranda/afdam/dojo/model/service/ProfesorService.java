package com.jacaranda.afdam.dojo.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.afdam.dojo.model.dto.DTOConverter;
import com.jacaranda.afdam.dojo.model.dto.ProfesorDTO;
import com.jacaranda.afdam.dojo.model.entity.Profesor;
import com.jacaranda.afdam.dojo.model.exceptions.ProfesorException;
import com.jacaranda.afdam.dojo.model.repo.ProfesorRepository;

@Service("profesorService")
public class ProfesorService {

	// Inyectamos el repositorio del profesor
	@Autowired
	private ProfesorRepository profesorRepository;

	// Inyectamos el converter del profesor
	@Autowired
	private DTOConverter profesorConverter;

	// Obtener todos los profesores
	public List<ProfesorDTO> getProfesores() throws ProfesorException {

		List<Profesor> profesores = (List<Profesor>) profesorRepository.findAll();

		if (profesores.size() == 0) {

			throw new ProfesorException("Error, no hay profesores");
		}

		List<ProfesorDTO> dto = new ArrayList<ProfesorDTO>();

		for (Profesor profesor : profesores) {

			dto.add(profesorConverter.fromProfesorToProfesorDTO(profesor));
		}

		return dto;
	}
	
	// Obtener un profesor
	public ProfesorDTO getProfesor(String curp) throws ProfesorException {
		
		Profesor profesor = profesorRepository.findProfesorByCurp(curp);
		
		if (profesor == null) {
			
			throw new ProfesorException("No existe el profesor");
		}
		
		ProfesorDTO dto = profesorConverter.fromProfesorToProfesorDTO(profesor);
		
		return dto;
	}
	
	// Modificar un profesor
	public ProfesorDTO upDateProfesor(String curp, ProfesorDTO dtoSent) throws ProfesorException {
		
		Profesor profesor = profesorRepository.findProfesorByCurp(curp);
		
		if (profesor == null) {
			throw new ProfesorException("No se puede actualizar, el profesor no existe");
		}
		
		upProfesor(profesor,dtoSent);
		profesorRepository.save(profesor);
		
		return profesorConverter.fromProfesorToProfesorDTO(profesor);
	}
	
	private void upProfesor(Profesor origin, ProfesorDTO sent) {
		
		origin.setName((sent.getName() == null) ? origin.getName() : sent.getName());
		origin.setSurnames((sent.getSurnames() == null) ? origin.getSurnames() : sent.getSurnames());
		origin.setBirthdate((sent.getBirthdate() == null) ? origin.getBirthdate() : sent.getBirthdate());
		origin.setTlf((sent.getTlf() == null) ? origin.getTlf() : sent.getTlf());
		origin.setAddress((sent.getAddress() == null) ? origin.getAddress() : sent.getAddress());
		origin.setEmail((sent.getEmail() == null) ? origin.getEmail() : sent.getEmail());
		origin.setPicture((sent.getPicture() == null) ? origin.getPicture() : sent.getPicture());
		
	}

}
