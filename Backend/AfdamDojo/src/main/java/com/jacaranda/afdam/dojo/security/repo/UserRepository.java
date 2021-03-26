package com.jacaranda.afdam.dojo.security.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jacaranda.afdam.dojo.security.model.User;

@Repository
public interface UserRepository extends JpaRepository <User,Integer> {
	
	public Optional<User>findByUsername (String username);
	
	public User findUsuarioByUsername(String username);

}
