package edu.curso.java.spring.proyectospring.service;

import java.util.List;

import edu.curso.java.spring.proyectospring.bo.CategoriaProducto;
import edu.curso.java.spring.proyectospring.bo.Producto;
import edu.curso.java.spring.proyectospring.rest.dto.ProductoDTO;


public interface ProductoService {

	Long guardarNuevoProducto(Producto producto, Long idCategoria) throws ProductoException;

	Producto buscarProductoPorId(Long id);

	List<Producto> recuperarProductos();

	List<Producto> buscarProductos(String nombre);

	List<Producto> buscarProductos(String nombre, Double precio);

	void borrarProductoPorId(Long id);
	
	void actualizarProducto(Producto producto);
	
	List<CategoriaProducto> recuperarCategoriasProducto();
	
	CategoriaProducto buscarCategoriaProductoPorId(Long id);

	List<Producto> recuperarProductosPorCategoria(Long id);
	
	Long guardarNuevaCategoria(CategoriaProducto categoriaProducto);
	

}