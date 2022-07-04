package edu.curso.java.spring.proyectospring.mvc;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import edu.curso.java.spring.proyectospring.bo.CategoriaProducto;
import edu.curso.java.spring.proyectospring.bo.Producto;
import edu.curso.java.spring.proyectospring.mvc.fom.ProductoForm;
import edu.curso.java.spring.proyectospring.service.ProductoException;
import edu.curso.java.spring.proyectospring.service.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductosController {

	private static  Logger log = LoggerFactory.getLogger(ProductosController.class);

	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/{id}")
	public String ver(Model model, @PathVariable Long id) {
		Producto producto = productoService.buscarProductoPorId(id);
		model.addAttribute("producto", producto);
		return "/productos/ver";
	}

	@GetMapping("/{id}/borrar")
	public String borrar(Model model, @PathVariable Long id) {
		productoService.borrarProductoPorId(id);
		return "redirect:/productos";
	}

	@GetMapping
	public String listar(Model model) {
		List<Producto> productos = productoService.recuperarProductos();
		model.addAttribute("productos", productos);
		return "/productos/listar";
	}

	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		this.cargarCategorias(model);
		model.addAttribute("productoForm", new ProductoForm());
		return "/productos/form";
	}
	
	@GetMapping("/{id}/editar")
	public String editar(Model model, @PathVariable Long id) {
		Producto producto = productoService.buscarProductoPorId(id);
		
		ProductoForm productoForm = new ProductoForm();
		productoForm.setId(producto.getId());
		productoForm.setNombre(producto.getNombre());
		productoForm.setPrecio(producto.getPrecio());
		
		if(producto.getCategoriaProducto() != null)
			productoForm.setCategoriaId(producto.getCategoriaProducto().getId());
		
		this.cargarCategorias(model);
		model.addAttribute("productoForm", productoForm);
		return "/productos/form";
	}

	private void cargarCategorias(Model model) {
		List<CategoriaProducto> categorias = productoService.recuperarCategoriasProducto();
		model.addAttribute("categorias", categorias);
	}

	
	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute(name = "productoForm") ProductoForm productoForm, BindingResult bindingResult, Model model) {

		log.info("Ejecutando el guardar: " + bindingResult.hasErrors());
		
		if(bindingResult.hasErrors()) {
			this.cargarCategorias(model);
			model.addAttribute("productoForm", productoForm);
			return "/productos/form";
		}
		
		Producto producto = null;
		Long idProducto = productoForm.getId();
		
		if(idProducto == null) {
			producto = new Producto();
		} else {
			producto = productoService.buscarProductoPorId(idProducto);
		}
		
		producto.setNombre(productoForm.getNombre());
		producto.setPrecio(productoForm.getPrecio());
		producto.setStockActual(productoForm.getStockActual());

		if(idProducto == null) {
			try {
				productoService.guardarNuevoProducto(producto, productoForm.getCategoriaId());
			} catch (ProductoException e) {
				log.error("Error al gurdar un nuevo producto", e.getMessage());
				return "redirect:/error";
			}

		} else {
			productoService.actualizarProducto(producto);
		}

		return "redirect:/productos";
	}
	
}