package edu.curso.java.spring.proyectospring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.spring.proyectospring.bo.Producto;
import edu.curso.java.spring.proyectospring.repository.ProductoRepository;
import java.util.*;

@Service
@Transactional
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
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
		return productoRepository.findAll();
	}
	
}
