package edu.curso.java.spring.proyectospring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.spring.proyectospring.bo.Producto;
import edu.curso.java.spring.proyectospring.repository.PersonaRepository;
import edu.curso.java.spring.proyectospring.repository.ProductoRepository;
import java.util.*;

@Service
@Transactional
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private PersonaRepository personaRepository;
	
	public ProductoServiceImpl() {
		System.out.println("Creando un ProductoServiceImpl");
	}
	
	@Override
	public Long guardarNuevoProducto(Producto producto) {
		productoRepository.save(producto);
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
	
}
