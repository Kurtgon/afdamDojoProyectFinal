package com.jacaranda.afdam.dojo.security.filter;

import javax.servlet.annotation.WebFilter;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jacaranda.afdam.dojo.security.common.SecurityConstants;

@WebFilter
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private static AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
		setFilterProcessesUrl(SecurityConstants.LOG_IN);
	}

	
	
}