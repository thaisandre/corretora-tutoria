package br.com.corretora;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		
		//System.out.println(connection.getCatalog());
		//System.out.println(connection.toString());
		
		System.out.println("conexão aberta!");
		connection.close();
	}
}
