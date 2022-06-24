package edu.curso.java.spring.proyectospring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.curso.java.spring.proyectospring.bo.Persona;

@Repository
public class PersonaRepositoryJdbcImpl implements PersonaRepository {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void initDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void altaDePersona(Persona persona) {
		String sql = "INSERT INTO PERSONA (ID, NOMBRE, APELLIDO, DIRECCION_ID) VALUES (?, ?, ?, ?)";
		this.jdbcTemplate.update(sql, persona.getId(), persona.getNombre(), persona.getApellido(), persona.getDireccionId());
	}

	@Override
	public Persona buscarPersonaPorId(Long id) {
		String sql = "SELECT ID, NOMBRE, APELLIDO, DIRECCION_ID FROM PERSONA WHERE ID = ?";
		return this.jdbcTemplate.queryForObject(sql, new RowMapper<Persona>() { @Override
			public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
				Persona persona = new Persona();
				persona.setId(rs.getLong("ID"));
				persona.setNombre(rs.getString("NOMBRE"));
				persona.setApellido(rs.getString("APELLIDO"));
				persona.setDireccionId(rs.getLong("DIRECCION_ID"));
				return persona;
			}
		}, id);
	}

	@Override
	public List<Persona> recuperarPersonas() {
		String sql = "SELECT ID, NOMBRE, APELLIDO, DIRECCION_ID FROM PERSONA";
		return this.jdbcTemplate.query(sql, new RowMapper<Persona>() { @Override
			public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
				Persona persona = new Persona();
				persona.setId(rs.getLong("ID"));
				persona.setNombre(rs.getString("NOMBRE"));
				persona.setApellido(rs.getString("APELLIDO"));
				persona.setDireccionId(rs.getLong("DIRECCION_ID"));
				return persona;
			}
		});
	}

	@Override
	public Long contarPersonas() {
		String sql = "SELECT COUNT(*) FROM PERSONA";
		return this.jdbcTemplate.queryForObject(sql, Long.class);
	}

	@Override
	public void borrarPersona(Long id) {
		String sql = "DELETE FROM PERSONA WHERE ID = ?";
		this.jdbcTemplate.update(sql);
	}

	@Override
	public void actualizarPersona(Persona persona) {
		String sql = "UPDATE PERSONA SET NOMBRE = ?, APELLIDO = ?, DIRECCION_ID = ? WHERE ID = ?";
		this.jdbcTemplate.update(sql, persona.getNombre(), persona.getApellido(), persona.getDireccionId(), persona.getId());
	}

}
