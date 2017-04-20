package br.com.corretora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import br.com.corretora.modelo.Usuario;

public class UsuarioDao {

	private Connection connection;
	
	public UsuarioDao(Connection connection) {
		this.connection = connection;
	}

	public Usuario salva(Usuario usuario) {

		String sql = "insert into usuario(nome, login, senha) values (?, ?, ?)";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getLogin());
			stmt.setString(3, usuario.getSenha());
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			
			rs.next();
			usuario.setId(rs.getInt(1));
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("usuario adicionado!");
		return usuario;
	}
}
