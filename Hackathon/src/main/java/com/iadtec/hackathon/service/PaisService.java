package com.iadtec.hackathon.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

@Service
public class PaisService {
	
	public class PaisRowMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Pais pais = new Pais();
			pais.setNome(rs.getString("NOME"));
			pais.setId(rs.getLong("ID"));
			return pais;
		}
	}
	
	@Autowired
    private JdbcTemplate jtm;
	
	private final String INSERT_SQL = "INSERT INTO PAIS(NOME) values(?)";
	private final String DELETE_SQL = "DELETE FROM PAIS WHERE ID=?";
	private final String UPDATE_SQL = "UPDATE PAIS SET NOME=? WHERE ID=?";
	
	
    public List<Pais> findAll() {

    	String sql = "SELECT * FROM PAIS";
        List<Pais> paises = jtm.query(sql, new PaisRowMapper());

        return paises;
    }

    public Pais findById(Long id) {

        String sql = "SELECT * FROM PAIS WHERE ID=?";

        Pais pais = (Pais) jtm.queryForObject(sql, new Object[]{id}, new PaisRowMapper());

        return pais;
    }
    
    public Pais findByNome(String nome) {

        String sql = "SELECT * FROM PAIS WHERE NOME=?";

        Pais pais = (Pais) jtm.queryForObject(sql, new Object[]{nome}, new PaisRowMapper());

        return pais;
    }
    
    public Pais create(final Pais pais) {
		KeyHolder holder = new GeneratedKeyHolder();
		jtm.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, pais.getNome());
				return ps;
			}
		}, holder);

		long newUserId = holder.getKey().longValue();
		pais.setId(newUserId);
		return pais;
	}
    
    public void delete(long id) {
    	jtm.update(DELETE_SQL, id);
    }
    
    public void update(Pais pais) {
		jtm.update(UPDATE_SQL,pais.getNome(),pais.getId());
    }
}