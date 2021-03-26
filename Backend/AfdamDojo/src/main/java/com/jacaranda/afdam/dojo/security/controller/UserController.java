package com.jacaranda.afdam.dojo.security.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.afdam.dojo.security.model.dto.UserDTO;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	//Inyectamos los servicios
	//@Autowired
	//private UsuarioService userService;
	
	@PostMapping("/login")
	public ResponseEntity<UserDTO>login(@RequestBody UserDTO userDTO){
		return ResponseEntity.status(HttpStatus.OK).body(userDTO);
	}
	
}
