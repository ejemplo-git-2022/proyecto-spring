package edu.curso.java.spring.proyectospring.service;

import org.springframework.scheduling.annotation.Async;

public interface EnviadorDeEmails {

	void enviarCorreoDeAltaDeProducto(String destinatario, String titulo, String mensaje);

}