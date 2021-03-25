package com.jacaranda.AfdamDojo.security.service;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//import com.jacaranda.AfdamDojo.security.model.dto.UsuarioDTOConverter;
import com.jacaranda.AfdamDojo.security.repo.UsuarioRepository;

@Service("usuarioService")
public class UsuarioService implements UserDetailsService{

	//Inyectamos el repositorio
	@Autowired
	private UsuarioRepository userRepository;
	
	//Inyectamos el converter dto
//	@Autowired
//	private UsuarioDTOConverter converter;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
	}
	
	public UserDetails loadUserById(int idUser) throws AuthenticationException {
		return userRepository.findById(idUser).orElseThrow(() -> new AuthenticationException("Id/username not found"));
	}

	
}
