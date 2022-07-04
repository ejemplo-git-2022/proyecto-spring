package edu.curso.java.spring.proyectospring.service;

public class ProductoException extends Exception {

	public ProductoException() {
		super();
	}

	public ProductoException(String mensaje) {
		super(mensaje);
	}

	public ProductoException(String mensaje, Throwable throwable) {
		super(mensaje, throwable);
	}
}
