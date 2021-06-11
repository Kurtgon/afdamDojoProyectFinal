package com.jacaranda.afdam.dojo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.jacaranda.afdam.dojo.security.common.SecurityConstants;
import com.jacaranda.afdam.dojo.security.filter.JWTAuthenticationFilter;
import com.jacaranda.afdam.dojo.security.filter.JWTAuthorizationFilter;
import com.jacaranda.afdam.dojo.security.service.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	// Inyectamos el servicio
	@Autowired
	private UserService userService;
	
	@Autowired
	private JWTAuthorizationFilter jwtAuthorizationFilter;
	
	// Inyectamos el passwordEncoder
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL_ALUMNO).permitAll()
		.antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL_PROFESOR).permitAll()
		.antMatchers(HttpMethod.POST, SecurityConstants.LOG_IN).permitAll()
		.and()
		.addFilter(new JWTAuthenticationFilter(authenticationManagerBean()))
		.addFilterBefore(jwtAuthorizationFilter, BasicAuthenticationFilter.class)
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
	}
}
