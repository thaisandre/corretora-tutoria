package br.com.corretora.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.corretora.ConnectionFactory;
import br.com.corretora.modelo.Investimento;

public class InvestimentoDao {

	Connection connection = new ConnectionFactory().getConnection();

	public void adiciona(Investimento investimento) {
		String sql = "insert into investimentos (valor, dataInicial, taxaDeJuros, tipo) values " + "(?, ?, ?, ?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDouble(1, investimento.getValor());
			Date data = Date.valueOf(investimento.getDataInicial());
			stmt.setDate(2, data);
			stmt.setDouble(3, investimento.getTaxaDeJuros());
			stmt.setString(4, investimento.getTipo().name());

			stmt.execute();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
