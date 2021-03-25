package com.jacaranda.AfdamDojo.security.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.AfdamDojo.security.model.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario,Integer> {
	
	public Optional<Usuario>findByUsername (String username);
	
	public Usuario findUsuarioByUsername(String username);

}
