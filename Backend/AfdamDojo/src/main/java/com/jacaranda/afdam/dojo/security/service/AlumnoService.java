package com.jacaranda.afdam.dojo.security.service;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.jacaranda.afdam.dojo.security.repo.UserRepository;

@Service("alumnoService")
public class AlumnoService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Alumno no encontrado")); 
	}
	
	public UserDetails loadUserById(int idUser) throws AuthenticationException {
		
		return userRepository.findById(idUser)
				.orElseThrow(()-> new AuthenticationException("Id/Alumno no encontrado"));
	
	}


}
