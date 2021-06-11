package com.jacaranda.afdam.dojo.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.afdam.dojo.model.dto.ProfesorDTO;
import com.jacaranda.afdam.dojo.model.exceptions.ProfesorException;
import com.jacaranda.afdam.dojo.model.service.ProfesorService;

@CrossOrigin
@RestController
@RequestMapping("/profesor")
public class ProfesorController {

	// Inyectamos el servicio del Profesor
	@Autowired
	private ProfesorService profesorService;

	// Obtener todos los profesores
	@GetMapping()
	public ResponseEntity<?> getProfesores() {

		ResponseEntity<?> response;

		try {

			List<ProfesorDTO> profesores = profesorService.getProfesores();
			response = ResponseEntity.ok(profesores);

		}

		catch (ProfesorException p) {

			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(p.getMessage());

		}

		catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado");
		}

		return response;
	}
	
	// Obtener un profesor
	@GetMapping("/{curp}")
	public ResponseEntity<?> getProfesor(@PathVariable String curp) {
		
		ResponseEntity<?> response;
		
		try {
			
			ProfesorDTO profesorDto = profesorService.getProfesor(curp);
			
			response = ResponseEntity.ok(profesorDto);
			
		}
		
		catch (ProfesorException p) {

			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(p.getMessage());

		}

		catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado");
		}

		return response;
		
	}
	
	// Modificar un profesor
	@PutMapping("/{curp}")
	public ResponseEntity<?> upDateProfesor(@PathVariable String curp, @RequestBody ProfesorDTO dto) {
		
		ResponseEntity<?> response;
		
		try {
			
			ProfesorDTO profesorDto = profesorService.upDateProfesor(curp, dto);
			
			response = ResponseEntity.ok(profesorDto);
			
		}
		
		catch (ProfesorException p) {
			
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(p.getMessage());
		}
		
		catch (Exception e) {
			
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado");
		}

		return response;
	}

}
