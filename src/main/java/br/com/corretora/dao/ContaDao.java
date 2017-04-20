package br.com.corretora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import br.com.corretora.modelo.Conta;

public class ContaDao {

	private Connection connection;
	
	public ContaDao(Connection connection) {
		this.connection = connection;
	}
	
	public Conta salva(Conta conta) {
		String sql = "insert into conta (saldo, numero, id_usuario) values (?, ?, ?)";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
			stmt.setDouble(1, conta.getSaldo());
			stmt.setString(2, conta.getNumero());
			stmt.setInt(3, conta.getUsuario().getId());
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			conta.setId(rs.getInt(1));
			System.out.println(conta.getId());
			
			//stmt.execute();]
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("conta adicionada!");
		return conta;
	}
	
}
