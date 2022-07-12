package edu.curso.java.spring.proyectospring.rest.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import edu.curso.java.spring.proyectospring.bo.Producto;

public class ProductoDTO {

	private Long id;
	
	@NotBlank
	private String nombre;
	
	@Positive
	private Double precio;
	private Long categoriaId;
	private String categoriaNombre;
	private Long stockActual;
	
	//@JsonFormat(shape = Shape.NUMBER, pattern="s")
	private Date fechaAlta;
	
	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Long getStockActual() {
		return stockActual;
	}

	public void setStockActual(Long stockActual) {
		this.stockActual = stockActual;
	}

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
		if(producto.getCategoriaProducto() != null) {
			this.categoriaNombre = producto.getCategoriaProducto().getNombre();			
		}
		this.fechaAlta = producto.getFechaAlta();
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
