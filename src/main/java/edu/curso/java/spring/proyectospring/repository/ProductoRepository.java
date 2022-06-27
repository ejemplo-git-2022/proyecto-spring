package edu.curso.java.spring.proyectospring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.proyectospring.bo.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	
	
	@Query("select p from Producto as p where p.nombre like ?1%")
	List<Producto> buscarProductos(String nombre);

	@Query("select p from Producto as p where p.nombre like ?1% or p.precio >= ?2")
	List<Producto> buscarProductos(String nombre, Double precio);

}
