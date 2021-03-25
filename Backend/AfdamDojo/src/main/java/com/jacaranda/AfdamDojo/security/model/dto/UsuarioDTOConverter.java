package com.jacaranda.AfdamDojo.security.model.dto;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.jacaranda.AfdamDojo.security.model.Usuario;
import com.jacaranda.AfdamDojo.security.model.enums.UserRole;

@Component
public class UsuarioDTOConverter {

	// Inyectamos el servicio PasswordEncoder
	@Autowired
	private PasswordEncoder passwordEncoder;

	// Creamos el método para convertir de un usuario a un dto
	public Usuario fromDTOToUsuario(UsuarioDTO dto) {
		// Creamos un Usuario
		Usuario user = new Usuario();
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
	public UsuarioDTO fromUsuarioToUsuarioDTO(Usuario user) {
		// Creamos un usuarioDTO
		UsuarioDTO dto = new UsuarioDTO();
		// Convertimos
		dto.setUsername(user.getUsername());
		dto.setRoles(user.getRoles());
		return dto;
	}
}	
