package com.jacaranda.afdam.dojo.security.model.dto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.jacaranda.afdam.dojo.model.entity.Alergia;
import com.jacaranda.afdam.dojo.model.entity.Alumno;
import com.jacaranda.afdam.dojo.model.entity.Profesor;
import com.jacaranda.afdam.dojo.model.entity.enums.Disciplinas;
import com.jacaranda.afdam.dojo.model.repo.AlergiaRepository;
import com.jacaranda.afdam.dojo.security.model.User;
import com.jacaranda.afdam.dojo.security.model.enums.UserRole;

@Component
public class SignUpDTOConverter {

	// Inyectamos el servicio PasswordEncoder
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// Inyectamos el servicio AlergiaRepository
	@Autowired
	private AlergiaRepository alergiaRepository;
	
	
	// Convertimos de AlumnoSignUpDTO a User
	public User fromAlumnoSignUpDTOToUsuario(AlumnoSignUpDTO dto) {
		//Creamos un usario
		User user = new User();
		// Seteamos los atributos usuario
		user.setUsername(dto.getUsername());
		// Encriptamos el password
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		user.setRoles(Set.of(UserRole.ALUMNO));
		user.setCreateTime(LocalDateTime.now());
		user.setUpdateTime(LocalDateTime.now());
		user.setLastPasswordChange(LocalDateTime.now());
		user.setLocked(false);
		user.setEnabled(true);
		user.setAuthenticationAttempts(0);
		user.setPasswordPolicyExpDate(LocalDateTime.now().plusDays(180));
		
		return user;
	}
	
	
	// Convertimos de AlumnoSignUpDTO a alumno
	public Alumno fromAlumnoSignUpDTOToAlumno(AlumnoSignUpDTO dto) {
		//Creamos un alumno
		Alumno alumno = new Alumno();
		//Seteamos los atributos del alumno
		alumno.setName(dto.getName());
		alumno.setSurnames(dto.getSurnames());
		alumno.setBirthdate(dto.getBirthdate());
		alumno.setCurp(dto.getCurp());
		alumno.setTlf(dto.getTlf());
		alumno.setAddress(dto.getAddress());
		alumno.setEmail(dto.getEmail());
		alumno.setPicture(dto.getPicture());
		alumno.setContact(dto.getContact());
		//alumno.setDiscipline(Disciplinas.valueOf(dto.getDiscipline()));
		//Alergia alergia = alergiaRepository.findAlergiaByAlergyName(dto.getAllergy());
		Set<Alergia>alergias = new HashSet<>();
		//alergias.add(alergia);
		alumno.setAllergy(alergias);
		
		return alumno;
	}
	
	
	// Convertimos de ProfesorSignUpDTO a User
	public User fromProfesorSignUpDTOToUsuario(ProfesorSignUpDTO dto) {
		//Creamos un usario
		User user = new User();
		// Seteamos los atributos usuario
		user.setUsername(dto.getUsername());
		// Encriptamos el password
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		user.setRoles(Set.of(UserRole.PROFESOR));
		user.setCreateTime(LocalDateTime.now());
		user.setUpdateTime(LocalDateTime.now());
		user.setLastPasswordChange(LocalDateTime.now());
		user.setLocked(false);
		user.setEnabled(true);
		user.setAuthenticationAttempts(0);
		user.setPasswordPolicyExpDate(LocalDateTime.now().plusDays(180));
		
		return user;
	}
	
	// Convertimos de ProfesorSignUpDTO a profesor
	public Profesor fromProfesorSignUpDTOToProfesor(ProfesorSignUpDTO dto) {
		//Creamos un profesor
		Profesor profesor = new Profesor();
		//Seteamos los atributos del Profesor
		profesor.setName(dto.getName());
		profesor.setSurnames(dto.getSurnames());
		profesor.setBirthdate(dto.getBirthdate());
		profesor.setCurp(dto.getCurp());
		profesor.setTlf(dto.getTlf());
		profesor.setAddress(dto.getAddress());
		profesor.setEmail(dto.getEmail());
		profesor.setPicture(dto.getPicture());
		
		return profesor;
	}
	
}
