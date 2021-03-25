package com.jacaranda.AfdamDojo.security.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.AfdamDojo.security.model.dto.UsuarioDTO;
//import com.jacaranda.AfdamDojo.security.service.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UsuarioController {

	//Inyectamos los servicios
	//@Autowired
	//private UsuarioService userService;
	
	@PostMapping("/login")
	public ResponseEntity<UsuarioDTO>login(@RequestBody UsuarioDTO userDTO){
		return ResponseEntity.status(HttpStatus.OK).body(userDTO);
	}
	
}
