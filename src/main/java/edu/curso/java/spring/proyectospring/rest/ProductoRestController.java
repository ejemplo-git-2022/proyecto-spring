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

import edu.curso.java.spring.proyectospring.bo.Producto;
import edu.curso.java.spring.proyectospring.rest.dto.ProductoDTO;
import edu.curso.java.spring.proyectospring.service.ProductoService;

@RestController
@RequestMapping("/api")
public class ProductoRestController {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/productos")
	public List<ProductoDTO> recuperarTodosLosProducto() {
		List<Producto> productos = productoService.recuperarProductos();
		List<ProductoDTO> productosDTO = new ArrayList<ProductoDTO>();
		for (Producto producto : productos) {
			productosDTO.add(new ProductoDTO(producto));
		}
		
		return productosDTO;
	}

	
	@GetMapping("/productos/{id}")
	public ResponseEntity<ProductoDTO> recuperarProductoPorId(@PathVariable Long id) {
		Producto producto = productoService.buscarProductoPorId(id);
		ProductoDTO productoDTO = new ProductoDTO(producto);
		return ResponseEntity.ok(productoDTO);
	}
	
	@PostMapping("/productos")
	public ResponseEntity<ProductoDTO> altaDeNuevoProducto(@RequestBody ProductoDTO productoDTO) {
		Producto producto = new Producto();
		producto.setNombre(productoDTO.getNombre());
		producto.setPrecio(productoDTO.getPrecio());
		Long idGenerado = productoService.guardarNuevoProducto(producto);
		productoDTO.setId(idGenerado);
		return ResponseEntity.status(HttpStatus.CREATED).body(productoDTO);
	}
	
	@PutMapping("/productos/{id}")
	public void actualizarProductoPor(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) {
		
	}
	
	@DeleteMapping("/productos/{id}")
	public ResponseEntity<?> borrarProductoPorId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	
	
}
