package com.jacaranda.afdam.dojo.security.model.dto;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.jacaranda.afdam.dojo.security.model.User;
import com.jacaranda.afdam.dojo.security.model.enums.UserRole;


@Component
public class UserDTOConverter {

	// Inyectamos el servicio PasswordEncoder
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	// Creamos el método para convertir de un usuario a un dto
	public User fromDTOToUsuario(UserDTO dto) {
		// Creamos un Usuario
		User user = new User();
		// Seteamos sus atributos
		user.setUsername(dto.getUsername());
		// Encriptamos la contraseña utilizando el passencoder
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

	// Creamos el método para convetir de un dto a un usuario
	public UserDTO fromUsuarioToUsuarioDTO(User user) {
		// Creamos un usuarioDTO
		UserDTO dto = new UserDTO();
		// Convertimos
		dto.setUsername(user.getUsername());
		dto.setRoles(user.getRoles());
		return dto;
	}


}
