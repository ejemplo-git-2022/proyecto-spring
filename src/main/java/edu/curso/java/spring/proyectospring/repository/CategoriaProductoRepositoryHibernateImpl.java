package edu.curso.java.spring.proyectospring.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.proyectospring.bo.CategoriaProducto;

@Repository
public class CategoriaProductoRepositoryHibernateImpl implements CategoriaProductoRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public CategoriaProducto buscarCategoriaProductoPorId(Long id) {
		return entityManager.find(CategoriaProducto.class, id);
	}

	@Override
	public List<CategoriaProducto> recuperarTodasLasCategoriasProducto() {
		return entityManager.createQuery("from CategoriaProducto as c order by c.nombre").getResultList();
	}

}
