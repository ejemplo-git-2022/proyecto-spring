package edu.curso.java.spring.proyectospring.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.*;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import edu.curso.java.spring.proyectospring.bo.CategoriaProducto;
import edu.curso.java.spring.proyectospring.bo.Producto;
import edu.curso.java.spring.proyectospring.rest.dto.ProductoDTO;
import edu.curso.java.spring.proyectospring.service.ProductoException;
import edu.curso.java.spring.proyectospring.service.ProductoService;

@RestController
@RequestMapping("/api")
public class ProductoRestController {

	private static  Logger log = LoggerFactory.getLogger(ProductoRestController.class);

	@Autowired
	private ProductoService productoService;


	@GetMapping("/categorias/{id}/productos")
	public List<ProductoDTO> buscarProductosPorCategoria(@PathVariable Long id) {
		CategoriaProducto categoriaProducto = productoService.buscarCategoriaProductoPorId(id);
		log.info("Categoria encontrada: " + categoriaProducto);
		
		if(categoriaProducto == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No podemos buscar productos con la categoria id: " + id);
			//throw new ProductoException("No podemos buscar productos con la categoria id: " + id);
		
		List<Producto> productos = productoService.recuperarProductosPorCategoria(id);
		List<ProductoDTO> productosDTO = new ArrayList<ProductoDTO>();
		for (Producto producto : productos) {
			productosDTO.add(new ProductoDTO(producto));
		}
		
		return productosDTO;
	}

	@GetMapping("/productos/buscar")
	public List<ProductoDTO> buscarProductos(@RequestParam String nombre, @RequestParam(required = false) Double precio) {
		
		log.info("Param nombre: " + nombre + " Param precio: " + precio);
		List<Producto> productos = null;
		
		if(precio == null)
			productos = productoService.buscarProductos(nombre);		
		else
			productos = productoService.buscarProductos(nombre, precio);		

			
		List<ProductoDTO> productosDTO = new ArrayList<ProductoDTO>();
		for (Producto producto : productos) {
			productosDTO.add(new ProductoDTO(producto));
		}
		
		return productosDTO;
	}

	
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
		Long idGenerado = productoService.guardarNuevoProducto(producto, productoDTO.getCategoriaId());
		productoDTO.setId(idGenerado);
		return ResponseEntity.status(HttpStatus.CREATED).body(productoDTO);
	}
	
	@PutMapping("/productos/{id}")
	public void actualizarProductoPor(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) {
		Producto producto = productoService.buscarProductoPorId(id);
		producto.setNombre(productoDTO.getNombre());
		producto.setPrecio(productoDTO.getPrecio());
		productoService.actualizarProducto(producto);
	}
	
	@DeleteMapping("/productos/{id}")
	public ResponseEntity<?> borrarProductoPorId(@PathVariable Long id) {
		productoService.borrarProductoPorId(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	
	
}
