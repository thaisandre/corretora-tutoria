package br.com.corretora.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.corretora.modelo.Investimento;

public class InvestimentoDao {

	private Connection connection;
	
	public InvestimentoDao(Connection connection) {
		this.connection = connection;
	}

	public Investimento salva(Investimento investimento) {
		String sql = "insert into investimento (valor, dataInicial, taxaDeJuros, tipo) values " + "(?, ?, ?, ?)";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setDouble(1, investimento.getValor());
			Date data = Date.valueOf(investimento.getDataInicial());
			stmt.setDate(2, data);
			stmt.setDouble(3, investimento.getTaxaDeJuros());
			stmt.setString(4, investimento.getTipo().name());
			stmt.execute();

			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			investimento.setId(rs.getInt(1));
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("investimento adicionado!");
		return investimento;
	}
}
