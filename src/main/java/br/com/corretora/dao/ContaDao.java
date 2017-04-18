package br.com.corretora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.corretora.ConnectionFactory;
import br.com.corretora.modelo.Conta;

public class ContaDao {

	private Connection connection = new ConnectionFactory().getConnection();

	public void adiciona(Conta conta) {
		String sql = "insert into contas (saldo) values (?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDouble(1, conta.getSaldo());
			
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
