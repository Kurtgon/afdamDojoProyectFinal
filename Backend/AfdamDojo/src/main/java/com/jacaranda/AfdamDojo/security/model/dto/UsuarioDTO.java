package com.jacaranda.AfdamDojo.security.model.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jacaranda.AfdamDojo.security.model.enums.UserRole;

@JsonInclude(Include.NON_NULL)
public class UsuarioDTO {

	// Atributos

	private String username;
	private String password;
	private Set<UserRole> roles;
	
	// Get y Set
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<UserRole> getRoles() {
		return roles;
	}
	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}
}
