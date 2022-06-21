package edu.curso.java.spring.proyectospring.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.curso.java.spring.proyectospring.rest.dto.ProductoDTO;

@RestController
@RequestMapping("/api")
public class ProductoRestController {

	@GetMapping("/productos")
	public List<ProductoDTO> recuperarTodosLosProducto() {
		ProductoDTO productoDTO1 = new ProductoDTO();
		productoDTO1.setId(1234L);
		productoDTO1.setNombre("Ejemplo 1234");
		productoDTO1.setPrecio(4500.0);
		
		ProductoDTO productoDTO2 = new ProductoDTO();
		productoDTO2.setId(1234L);
		productoDTO2.setNombre("Ejemplo 1234");
		productoDTO2.setPrecio(4500.0);
		
		List<ProductoDTO> productosDTO = new ArrayList<ProductoDTO>();
		productosDTO.add(productoDTO1);
		productosDTO.add(productoDTO2);
		return productosDTO;
	}

	
	@GetMapping("/productos/{id}")
	public ProductoDTO recuperarProductoPorId(@PathVariable Long id) {
		ProductoDTO productoDTO = new ProductoDTO();
		productoDTO.setId(1234L);
		productoDTO.setNombre("Ejemplo 1234");
		productoDTO.setPrecio(4500.0);
		return productoDTO;
	}
	
}
