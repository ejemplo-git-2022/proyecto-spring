package edu.curso.java.spring.proyectospring.bo;

public class Persona {
	
	public Persona(Long id, String nombre, String apellido, Long direccionId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccionId = direccionId;
	}

	public Persona() {
		
	}
	
	private Long id;
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Long getDireccionId() {
		return direccionId;
	}
	public void setDireccionId(Long direccionId) {
		this.direccionId = direccionId;
	}
	private String nombre;
	private String apellido;
	private Long direccionId;

}
