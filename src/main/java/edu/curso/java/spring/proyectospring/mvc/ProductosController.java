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

	@GetMapping("/borrar/{id}")
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
}