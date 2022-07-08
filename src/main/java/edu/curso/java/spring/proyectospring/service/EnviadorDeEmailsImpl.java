package edu.curso.java.spring.proyectospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EnviadorDeEmailsImpl implements EnviadorDeEmails {

	@Autowired
    private JavaMailSender emailSender;
	   
	@Async
	@Override
	public void enviarCorreoDeAltaDeProducto(String destinatario, String titulo, String mensaje) {

        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("claudio.zamoszczyk@gmail.com");
        message.setTo(destinatario);
        message.setSubject(titulo);
        message.setText(mensaje);
        
        emailSender.send(message);
		
		System.out.println("Listo termino el envio...");
		
	}
	
}
