package br.com.corretora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.corretora.modelo.Aplicacao;
import br.com.corretora.modelo.Conta;
import br.com.corretora.modelo.Investimento;
import br.com.corretora.modelo.TipoDeInvestimento;

public class AplicacaoDao {

	private Connection connection;

	public AplicacaoDao(Connection connection) {
		this.connection = connection;
	}

	public Aplicacao salva(Aplicacao aplicacao) {
		String sql = "insert into aplicacao (id_conta, id_investimento) values (?, ?)";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, aplicacao.getConta().getId());
			stmt.setInt(2, aplicacao.getInvestimento().getId());
			stmt.execute();

			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			aplicacao.setId(rs.getInt(1));

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("aplicacao adicionada!");
		return aplicacao;
	}

	public void delete(Aplicacao aplicacao) {
		String sql = "delete from aplicacao where id=?";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, aplicacao.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Investimento> getInvestimentosPor(Conta conta) {

		List<Investimento> investimentos = new ArrayList<>();

		String sql = "select * from investimento i" + " join" + " aplicacao a on i.id = a.id_investimento" + " join"
				+ " conta c on c.id = a.id_conta" + " where c.id = ?";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, conta.getId());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Investimento investimento = new Investimento(rs.getDouble("valor"),
						rs.getDate("dataInicial").toLocalDate(), rs.getDouble("taxaDeJuros"),
						TipoDeInvestimento.valueOf(rs.getString("tipo")));

				investimento.setId(rs.getInt("id"));

				investimentos.add(investimento);

			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return investimentos;
	}

}
