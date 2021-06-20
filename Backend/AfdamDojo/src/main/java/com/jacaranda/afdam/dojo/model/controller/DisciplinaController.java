package com.jacaranda.afdam.dojo.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.afdam.dojo.model.service.DisciplinaService;

@CrossOrigin
@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {
	
	// Inyectamos el servicio Disciplinas
	@Autowired
	private DisciplinaService disciplinaService;
	
	// Obtener todas las disciplinas
	@GetMapping
	public ResponseEntity<?>getDisciplinas() {
		
		ResponseEntity<?> response;
		
		try {
			List<String> disciplinas = disciplinaService.getDisciplinas();
			response = ResponseEntity.ok(disciplinas);
			
		}catch (Exception e) {
			
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado");
		}
		
		return response;
	}

}
