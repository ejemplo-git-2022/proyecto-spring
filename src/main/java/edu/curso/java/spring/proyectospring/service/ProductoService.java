package edu.curso.java.spring.proyectospring.service;

import java.util.List;

import edu.curso.java.spring.proyectospring.bo.CategoriaProducto;
import edu.curso.java.spring.proyectospring.bo.Producto;
import edu.curso.java.spring.proyectospring.rest.dto.ProductoDTO;


public interface ProductoService {

	Long guardarNuevoProducto(Producto producto, Long idCategoria);

	Producto buscarProductoPorId(Long id);

	List<Producto> recuperarProductos();

	List<Producto> buscarProductos(String nombre);

	List<Producto> buscarProductos(String nombre, Double precio);

	void borrarProductoPorId(Long id);
	
	void actualizarProducto(Producto producto);
	
	List<CategoriaProducto> recuperarCategoriasProducto();
	
	CategoriaProducto buscarCategoriaProductoPorId(Long id);

	List<ProductoDTO> recuperarProductosPorCategoria(Long id);

}