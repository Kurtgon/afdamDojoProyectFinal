package com.jacaranda.afdam.dojo.security.service;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jacaranda.afdam.dojo.model.entity.Alumno;
import com.jacaranda.afdam.dojo.model.entity.Profesor;
import com.jacaranda.afdam.dojo.model.exceptions.UserException;
import com.jacaranda.afdam.dojo.model.repo.AlumnoRepository;
import com.jacaranda.afdam.dojo.model.repo.ProfesorRepository;
import com.jacaranda.afdam.dojo.security.model.User;
import com.jacaranda.afdam.dojo.security.model.dto.AlumnoSignUpDTO;
import com.jacaranda.afdam.dojo.security.model.dto.ProfesorSignUpDTO;
import com.jacaranda.afdam.dojo.security.model.dto.SignUpDTOConverter;
import com.jacaranda.afdam.dojo.security.model.dto.UserDTO;
import com.jacaranda.afdam.dojo.security.model.dto.UserDTOConverter;
import com.jacaranda.afdam.dojo.security.repo.UserRepository;

@Service("userService")
public class UserService implements UserDetailsService {

	// Inyectamos el repositorio
	@Autowired
	private UserRepository userRepository;

	// Inyectamos el repositorio del alumno
	@Autowired
	private AlumnoRepository alumnoRepository;

	// Inyectamos el repositorio del profesor
	@Autowired
	private ProfesorRepository profesorRepository;

	// Inyectamos los converters
	@Autowired
	private UserDTOConverter userDTOConverter;

	@Autowired
	private SignUpDTOConverter signUpDTOConverter;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
	}

	public UserDetails loadUserById(int idUser) throws AuthenticationException {
		return userRepository.findById(idUser).orElseThrow(() -> new AuthenticationException("Id/username not found"));
	}

	// Creamos el método para crear el alumno
	public UserDTO createNewAlumno(AlumnoSignUpDTO dto) throws UserException {
		// Comprobamos que el usuario no existe
		User user = userRepository.findUsuarioByUsername(dto.getUsername());
		if (user != null) {
			throw new UserException("El usuario ya existe");
		}
		// Creamos el usuario
		User newUser = signUpDTOConverter.fromAlumnoSignUpDTOToUsuario(dto);
		// Guardamos el usuario
		userRepository.save(newUser);
		// Creamos el alumno
		Alumno alumno = signUpDTOConverter.fromAlumnoSignUpDTOToAlumno(dto);
		// Seteamos el usuario
		alumno.setUser(newUser);
		// Guardamos el alumno
		alumnoRepository.save(alumno);

		return userDTOConverter.fromUsuarioToUsuarioDTO(newUser);
	}

	// Creamos el método para crear al profesor
	public UserDTO createNewProfesor(ProfesorSignUpDTO dto) throws UserException {
		// Comprobamos que el usuario no existe
		User user = userRepository.findUsuarioByUsername(dto.getUsername());
		if (user != null) {
			throw new UserException("El usuario ya existe");
		}
		// Creamos el usuario
		User newUser = signUpDTOConverter.fromProfesorSignUpDTOToUsuario(dto);
		// Guardamos el usuario
		userRepository.save(newUser);
		// Creamos el profesor
		Profesor profesor = signUpDTOConverter.fromProfesorSignUpDTOToProfesor(dto);
		// Seteamos al usuario
		profesor.setUser(newUser);
		// Guardamos el profesor
		profesorRepository.save(profesor);

		return userDTOConverter.fromUsuarioToUsuarioDTO(newUser);

	}
}
