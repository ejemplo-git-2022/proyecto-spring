package edu.curso.java.spring.proyectospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.spring.proyectospring.bo.CategoriaProducto;
import edu.curso.java.spring.proyectospring.bo.Producto;
import edu.curso.java.spring.proyectospring.repository.CategoriaProductoRepository;
import edu.curso.java.spring.proyectospring.repository.PersonaRepository;
import edu.curso.java.spring.proyectospring.repository.ProductoRepository;
import edu.curso.java.spring.proyectospring.rest.dto.ProductoDTO;

import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductoServiceImpl implements ProductoService {

 
    
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private CategoriaProductoRepository categoriaProductoRepository;
	
	@Autowired
	private EnviadorDeEmails enviadorDeEmails;
	
	public ProductoServiceImpl() {
		System.out.println("Creando un ProductoServiceImpl");
	}
	
	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public Long guardarNuevoProducto(Producto producto, Long categoriaId) throws ProductoException {
		CategoriaProducto categoriaProducto = categoriaProductoRepository.buscarCategoriaProductoPorId(categoriaId);
		producto.setCategoriaProducto(categoriaProducto);
		
		if(producto.getFechaAlta() == null)
			producto.setFechaAlta(new Date());
		
		productoRepository.save(producto);
	
		if(producto.getStockActual() == 0)
			throw new ProductoException("No se puede guardar un producto con stock en 0");
	
		enviadorDeEmails.enviarCorreoDeAltaDeProducto("pepe@hotmail.com", "Titulo1", "Ejemplo mensaje");

		return producto.getId();
	}
	
	@Override
	public Producto buscarProductoPorId(Long id) {
		Optional<Producto> productoOptional = productoRepository.findById(id);
		return productoOptional.get();
	}
	
	@Override
	public List<Producto> recuperarProductos() {
		//System.out.println("Cantidad total de personas: " + personaRepository.contarPersonas());
		
		return productoRepository.findAll();
	}

	@Override
	public void borrarProductoPorId(Long id) {
		productoRepository.deleteById(id);
	}

	@Override
	public void actualizarProducto(Producto producto) {
		productoRepository.save(producto);
		// TODO Auto-generated method stub
		
	}

	@Override
	@Cacheable("categorias")
	public List<CategoriaProducto> recuperarCategoriasProducto() {
		// TODO Auto-generated method stub
		return categoriaProductoRepository.recuperarTodasLasCategoriasProducto();
	}

	@Cacheable("categoriaPorId")
	@Override
	public CategoriaProducto buscarCategoriaProductoPorId(Long id) {
		// TODO Auto-generated method stub
		return categoriaProductoRepository.buscarCategoriaProductoPorId(id);
	}

	@Override
	public List<Producto> buscarProductos(String nombre) {
		// TODO Auto-generated method stub
		return productoRepository.buscarProductos(nombre);
	}

	@Override
	public List<Producto> buscarProductos(String nombre, Double precio) {
		// TODO Auto-generated method stub
		return productoRepository.buscarProductos(nombre, precio);
	}

	@Override
	public List<Producto> recuperarProductosPorCategoria(Long id) {
		// TODO Auto-generated method stub
		return productoRepository.recuperarProductosPorCategoria(id);
	}
	
	
	
	
	
}
