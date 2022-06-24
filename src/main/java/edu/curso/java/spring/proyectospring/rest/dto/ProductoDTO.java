package edu.curso.java.spring.proyectospring.rest.dto;

import edu.curso.java.spring.proyectospring.bo.Producto;

public class ProductoDTO {

	private Long id;
	private String nombre;
	private Double precio;
	private Long categoriaId;
	private String categoriaNombre;
	
	public String getCategoriaNombre() {
		return categoriaNombre;
	}

	public void setCategoriaNombre(String categoriaNombre) {
		this.categoriaNombre = categoriaNombre;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public ProductoDTO() { }
	
	public ProductoDTO(Producto producto) {
		this.id = producto.getId();
		this.nombre = producto.getNombre();
		this.precio = producto.getPrecio();
		this.categoriaNombre = producto.getCategoriaProducto().getNombre();
	}
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
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
}
