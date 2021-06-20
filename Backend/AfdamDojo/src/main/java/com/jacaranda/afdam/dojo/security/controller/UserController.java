package com.jacaranda.afdam.dojo.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jacaranda.afdam.dojo.model.service.EmailService;
import com.jacaranda.afdam.dojo.security.common.SecurityConstants;
import com.jacaranda.afdam.dojo.security.model.dto.AlumnoSignUpDTO;
import com.jacaranda.afdam.dojo.security.model.dto.ProfesorSignUpDTO;
import com.jacaranda.afdam.dojo.security.model.dto.UserDTO;
import com.jacaranda.afdam.dojo.security.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	// Inyectamos los servicios
	@Autowired
	private UserService userService;

	// Inyectamos el servicio del envio del email
	@Autowired
	private EmailService emailService;

	// SignUp del Alumno
	@PostMapping(SecurityConstants.SIGN_UP_URL_ALUMNO)
	public ResponseEntity<?> signUp(@RequestBody AlumnoSignUpDTO alumnoSignUpDTO) {

		ResponseEntity<?> response = null;

		try {

			response = ResponseEntity.status(HttpStatus.CREATED).body(userService.createNewAlumno(alumnoSignUpDTO));
		}

		catch (Exception ex) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		if (response.getStatusCode().equals(HttpStatus.CREATED)) {
			emailService.sendSignUp(alumnoSignUpDTO.getUsername(), alumnoSignUpDTO.getPassword(),
					alumnoSignUpDTO.getEmail());
		}

		return response;
	}

	// SignUp del Profesor
	@PostMapping(SecurityConstants.SIGN_UP_URL_PROFESOR)
	public ResponseEntity<?> signUp(@RequestBody ProfesorSignUpDTO profesorSignUpDTO) {

		ResponseEntity<?> response = null;

		try {
			response = ResponseEntity.status(HttpStatus.CREATED).body(userService.createNewProfesor(profesorSignUpDTO));
		}

		catch (Exception ex) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		if (response.getStatusCode().equals(HttpStatus.CREATED)) {
			emailService.sendSignUp(profesorSignUpDTO.getUsername(), profesorSignUpDTO.getPassword(),
					profesorSignUpDTO.getEmail());
		}
		
		return response;
	}

	@PostMapping(SecurityConstants.LOG_IN)
	public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO) {

		return ResponseEntity.status(HttpStatus.OK).body(userDTO);
		
	}

}
