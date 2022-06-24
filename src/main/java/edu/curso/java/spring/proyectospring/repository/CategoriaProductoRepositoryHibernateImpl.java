package edu.curso.java.spring.proyectospring.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.proyectospring.bo.CategoriaProducto;

@Repository
public class CategoriaProductoRepositoryHibernateImpl implements CategoriaProductoRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public CategoriaProducto buscarCategoriaProductoPorId(Long id) {
		return sessionFactory.getCurrentSession().load(CategoriaProducto.class, id);
	}

	@Override
	public List<CategoriaProducto> recuperarTodasLasCategoriasProducto() {
		return sessionFactory.getCurrentSession().createQuery("from CategoriaProducto as c order by c.nombre").list();
	}

}
