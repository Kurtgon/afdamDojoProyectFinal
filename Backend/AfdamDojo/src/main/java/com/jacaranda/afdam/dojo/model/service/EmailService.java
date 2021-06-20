package com.jacaranda.afdam.dojo.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jacaranda.afdam.dojo.model.common.Constants;

@Service("emailService")
public class EmailService {
	
	//Inyectamos la clase JavaMailSender 
	@Autowired
	private JavaMailSender mailSender;
	
	//Creamos el método para enviar el email cuando se crea el usuario
	public void sendSignUp(String username, String password, String email) {
		
		String asunto = "Registro con Exito";
		
		String msg = " Bienvenido a AfdamDojo. \r\n"
				+ " Tus credenciales son: \r\n"
				+ "	Username: " + username +  "\r\n"
				+ "	Password: " + password + "\r\n"
				+ "\r\n"
				+ "	¡El password es temporal, por favor cambialo lo antes posible! Gracias. \r\n"
				+ "\r\n"
				+ " Entra en: " + Constants.registrarUsuario  + "\r\n";
		
		this.sendMensaje(email,asunto,msg);
	}

	// Creamos el método para enviar el email desde emailSender
	public void sendMensaje(String para, String asunto, String msg) {
		
		SimpleMailMessage mensaje = new SimpleMailMessage();
		// Seteamos las partes del mensaje
		mensaje.setFrom("afdamdojo@gmail.com");
		mensaje.setTo(para);
		mensaje.setSubject(asunto);
		mensaje.setText(msg);
		
		mailSender.send(mensaje);
	}
}
