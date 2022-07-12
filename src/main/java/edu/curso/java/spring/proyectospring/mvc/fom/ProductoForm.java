package edu.curso.java.spring.proyectospring.mvc.fom;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;

public class ProductoForm {
	
	private Long id;
	private Long categoriaId;
	
	@NotBlank
	private String nombre;

	@NotNull
	@Positive
	private Double precio;
	
	private Long stockActual;
	
	private MultipartFile foto;
	
	
	public MultipartFile getFoto() {
		return foto;
	}
	public void setFoto(MultipartFile foto) {
		this.foto = foto;
	}
	public Long getStockActual() {
		return stockActual;
	}
	public void setStockActual(Long stockActual) {
		this.stockActual = stockActual;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
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
