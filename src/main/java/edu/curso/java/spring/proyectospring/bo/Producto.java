package edu.curso.java.spring.proyectospring.bo;

import javax.persistence.*;

@Entity
public class Producto {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private Double precio;
	private Long stockActual;
	
	public Long getStockActual() {
		return stockActual;
	}

	public void setStockActual(Long stockActual) {
		this.stockActual = stockActual;
	}
	
	@ManyToOne
	private CategoriaProducto categoriaProducto;
	
	public CategoriaProducto getCategoriaProducto() {
		return categoriaProducto;
	}
	
	public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
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
