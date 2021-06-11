package com.jacaranda.afdam.dojo.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.afdam.dojo.model.service.PersonaService;

@CrossOrigin
@RestController
@RequestMapping("/persona")
public class PersonaController {
	
	//Inyectamos los servicios
	@Autowired
	private PersonaService personaService;
	
	//GetMapping 
	@GetMapping()
	public ResponseEntity<?>getPersona(){
		
		ResponseEntity<?> response = null;
		
		try {
			
			
		}catch (Exception e) {
			
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado");
		}
		
		return response;
	}
	
	

}
