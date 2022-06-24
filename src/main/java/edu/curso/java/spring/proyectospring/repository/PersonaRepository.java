package edu.curso.java.spring.proyectospring.repository;

import edu.curso.java.spring.proyectospring.bo.Persona;
import java.util.*;

public interface PersonaRepository {

	public void altaDePersona(Persona  persona);
	public Persona buscarPersonaPorId(Long id);
	public List<Persona> recuperarPersonas();
	public Long contarPersonas();
	public void borrarPersona(Long id);
	public void actualizarPersona(Persona  persona);
	
}
