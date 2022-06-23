package edu.curso.java.spring.proyectospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.proyectospring.bo.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
