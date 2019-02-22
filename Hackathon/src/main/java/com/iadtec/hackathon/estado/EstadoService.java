package com.iadtec.hackathon.estado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.iadtec.hackathon.service.Pais;
import com.iadtec.hackathon.service.PaisService.PaisRowMapper;

@Service
public class EstadoService {
	
	public class EstadoRowMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Estado estado = new Estado();
			estado.setNome(rs.getString("NOME"));
			estado.setUF(rs.getString("UF"));
			estado.setNomePais(rs.getString("PAIS"));
			estado.setId(rs.getLong("ID"));
			return estado;
		}
	}
	
	private final String INSERT_SQL = "INSERT INTO ESTADO(NOME,UF,PAIS) values(?,?,?)";
	private final String DELETE_SQL = "DELETE FROM ESTADO WHERE ID=?";
	private final String UPDATE_SQL = "UPDATE ESTADO SET NOME=?, UF=?, PAIS=? WHERE ID=?";
	
	@Autowired
    private JdbcTemplate jtm;

    public List<Estado> findAll() {

    	String sql = "SELECT ESTADO.ID, ESTADO.NOME, ESTADO.UF, PAIS.NOME AS PAIS FROM ESTADO INNER JOIN PAIS ON PAIS.ID = ESTADO.PAIS";
        List<Estado> estados = jtm.query(sql, new EstadoRowMapper());

        return estados;
    }

    public Estado findById(Long id) {

        String sql = "SELECT ESTADO.ID, ESTADO.NOME, ESTADO.UF, PAIS.NOME AS PAIS FROM ESTADO INNER JOIN PAIS ON PAIS.ID = ESTADO.PAIS WHERE ID=?";

        Estado estado = (Estado) jtm.queryForObject(sql, new Object[]{id}, new EstadoRowMapper());

        return estado;
    }
    
    public Estado findByNome(String nome) {

        String sql = "SELECT ESTADO.ID, ESTADO.NOME, ESTADO.UF, PAIS.NOME AS PAIS FROM ESTADO INNER JOIN PAIS ON PAIS.ID = ESTADO.PAIS WHERE ESTADO.NOME=?";

        Estado estado = (Estado) jtm.queryForObject(sql, new Object[]{nome}, new EstadoRowMapper());

        return estado;
    }
    
    
    public Estado create(final Estado estado) {
		KeyHolder holder = new GeneratedKeyHolder();
		jtm.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, estado.getNome());
				ps.setString(2, estado.getUF());
				ps.setLong(3, estado.getPais());
				
				return ps;
			}
		}, holder);

		long newUserId = holder.getKey().longValue();
		estado.setId(newUserId);
		return estado;
	}
    
    public void delete(long id) {
    	jtm.update(DELETE_SQL, id);
    }
    
    public void update(Estado estado) {
		jtm.update(UPDATE_SQL,estado.getNome(),estado.getUF(),estado.getPais(),estado.getId());
    }

}
