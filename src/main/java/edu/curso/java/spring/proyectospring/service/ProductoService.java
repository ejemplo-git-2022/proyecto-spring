package edu.curso.java.spring.proyectospring.service;

import java.util.List;

import edu.curso.java.spring.proyectospring.bo.CategoriaProducto;
import edu.curso.java.spring.proyectospring.bo.Producto;

public interface ProductoService {

	Long guardarNuevoProducto(Producto producto, Long idCategoria);

	Producto buscarProductoPorId(Long id);

	List<Producto> recuperarProductos();
	
	void borrarProductoPorId(Long id);
	
	void actualizarProducto(Producto producto);
	
	List<CategoriaProducto> recuperarCategoriasProducto();
	
	CategoriaProducto buscarCategoriaProductoPorId(Long id);

}