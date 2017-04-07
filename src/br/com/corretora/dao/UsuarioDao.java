package br.com.corretora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.corretora.ConnectionFactory;
import br.com.corretora.modelo.Usuario;

public class UsuarioDao {
	
	Connection connection = new ConnectionFactory().getConnection();
	
	public void adiciona(Usuario usuario) {
		
		String sql = "insert into usuarios(nome) values (?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
