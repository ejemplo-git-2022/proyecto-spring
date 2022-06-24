package edu.curso.java.spring.proyectospring.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.curso.java.spring.proyectospring.bo.CategoriaProducto;
import edu.curso.java.spring.proyectospring.bo.Producto;
import edu.curso.java.spring.proyectospring.rest.dto.CategoriaProductoDTO;
import edu.curso.java.spring.proyectospring.rest.dto.ProductoDTO;
import edu.curso.java.spring.proyectospring.service.ProductoService;

@RestController
@RequestMapping("/api")
public class CategoriaProductoRestController {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/categorias")
	public List<CategoriaProductoDTO> recuperarTodosLasCategorias() {
		List<CategoriaProducto> categorias = productoService.recuperarCategoriasProducto();
		List<CategoriaProductoDTO> categoriasDTO = new ArrayList<CategoriaProductoDTO>();
		for (CategoriaProducto categoriaProducto : categorias) {
			categoriasDTO.add(new CategoriaProductoDTO(categoriaProducto));
		}
		
		return categoriasDTO;
	}

	
	@GetMapping("/categorias/{id}")
	public ResponseEntity<CategoriaProductoDTO> recuperarCategoriaPorId(@PathVariable Long id) {
		CategoriaProducto categoriaProducto = productoService.buscarCategoriaProductoPorId(id);
		CategoriaProductoDTO productoDTO = new CategoriaProductoDTO(categoriaProducto);
		return ResponseEntity.ok(productoDTO);
	}
	
	
}
