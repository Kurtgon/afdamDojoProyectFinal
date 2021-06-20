package com.jacaranda.afdam.dojo.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.afdam.dojo.model.service.AlergiaGravedadService;

@CrossOrigin
@RestController
@RequestMapping("/alergiasgravedad")
public class AlergiaGravedadController {
	
	// Inyectamos el servicio AlergiasGravedad
	@Autowired
	private AlergiaGravedadService alergiaGravedadService;
	
	//Obtener todos los niveles de gravedad de las alergias
	@GetMapping
	public ResponseEntity<?>getAlergiaGravedad(){
		
		ResponseEntity<?> response;
		
		try {
			
		List<String> alergiaGravedad = alergiaGravedadService.getAlergiasGravedad();
		response = ResponseEntity.ok(alergiaGravedad);
			
		}catch (Exception e) {
			
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado");
		}
		
		
		return response;
	}

}
