package edu.curso.java.spring.proyectospring.repository;

import edu.curso.java.spring.proyectospring.bo.CategoriaProducto;
import java.util.*;

public interface CategoriaProductoRepository {

	public CategoriaProducto buscarCategoriaProductoPorId(Long id);
	public List<CategoriaProducto> recuperarTodasLasCategoriasProducto();
	public Long guardarNuevaCategoria(CategoriaProducto categoriaProducto);
	
}
