package edu.curso.java.spring.proyectospring.rest.dto;

import edu.curso.java.spring.proyectospring.bo.CategoriaProducto;

public class CategoriaProductoDTO {

	private Long id;
	private String nombre;
	
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
	public CategoriaProductoDTO(CategoriaProducto categoriaProducto) {
		this.id = categoriaProducto.getId();
		this.nombre = categoriaProducto.getNombre();
	}
	
	public CategoriaProductoDTO() {
		
	}

}
