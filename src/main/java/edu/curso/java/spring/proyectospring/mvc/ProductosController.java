package edu.curso.java.spring.proyectospring.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.curso.java.spring.proyectospring.bo.CategoriaProducto;
import edu.curso.java.spring.proyectospring.bo.Producto;
import edu.curso.java.spring.proyectospring.mvc.fom.ProductoForm;
import edu.curso.java.spring.proyectospring.service.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductosController {

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
		List<CategoriaProducto> categorias = productoService.recuperarCategoriasProducto();
		model.addAttribute("categorias", categorias);
		model.addAttribute("productoForm", new ProductoForm());
		return "/productos/form";
	}
	
	@GetMapping("/{id}/editar")
	public String editar(Model model, @PathVariable Long id) {
		Producto producto = productoService.buscarProductoPorId(id);
		List<CategoriaProducto> categorias = productoService.recuperarCategoriasProducto();
		
		ProductoForm productoForm = new ProductoForm();
		productoForm.setId(producto.getId());
		productoForm.setNombre(producto.getNombre());
		productoForm.setPrecio(producto.getPrecio());
		
		if(producto.getCategoriaProducto() != null)
			productoForm.setCategoriaId(producto.getCategoriaProducto().getId());
		
		model.addAttribute("categorias", categorias);
		model.addAttribute("productoForm", productoForm);
		return "/productos/form";
	}

	
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute(name = "productoForm") ProductoForm productoForm, Model model) {

		Producto producto = new Producto();
		producto.setNombre(productoForm.getNombre());
		producto.setPrecio(productoForm.getPrecio());
		productoService.guardarNuevoProducto(producto, productoForm.getCategoriaId());
		return "redirect:/productos";
	}
	
}