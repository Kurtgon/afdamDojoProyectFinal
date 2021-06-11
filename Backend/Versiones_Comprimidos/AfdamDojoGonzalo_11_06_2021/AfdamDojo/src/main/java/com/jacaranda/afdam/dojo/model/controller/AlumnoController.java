package com.jacaranda.afdam.dojo.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.afdam.dojo.model.dto.AlumnoDTO;
import com.jacaranda.afdam.dojo.model.entity.Alumno;
import com.jacaranda.afdam.dojo.model.exceptions.AlumnoException;
import com.jacaranda.afdam.dojo.model.service.AlumnoService;

@CrossOrigin
@RestController
@RequestMapping("/alumno")
public class AlumnoController {

	// Inyectamos el servicio Alumnos
	@Autowired
	private AlumnoService alumnoService;

	// Obtener todos los alumnos
	@GetMapping()
	public ResponseEntity<?> getAlumnos() {

		ResponseEntity<?> response;

		try {

			List<AlumnoDTO> alumnos = alumnoService.getAlumnos();
			response = ResponseEntity.ok(alumnos);

		}

		catch (AlumnoException a) {

			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(a.getMessage());
		}

		catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado");
		}

		return response;
	}

	// Obtener un alumno
	@GetMapping("/{curp}")
	public ResponseEntity<?> getAlumno(@PathVariable String curp) {

		ResponseEntity<?> response;

		try {

			AlumnoDTO alumnoDto = alumnoService.getAlumno(curp);

			response = ResponseEntity.ok(alumnoDto);
		}

		catch (AlumnoException a) {

			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(a.getMessage());
		}

		catch (Exception e) {

			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado");
		}

		return response;
	}

	// Modificar un alumno
	@PutMapping("/{curp}")
	public ResponseEntity<?> upDateAlumno(@PathVariable String curp, @RequestBody AlumnoDTO dto) {

		ResponseEntity<?> response;

		try {

			AlumnoDTO alumnoDto = alumnoService.upDateAlumno(curp, dto);

			response = ResponseEntity.ok(alumnoDto);

		} catch (AlumnoException a) {

			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(a.getMessage());
		}

		catch (Exception e) {

			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado");
		}

		return response;
	}
}
