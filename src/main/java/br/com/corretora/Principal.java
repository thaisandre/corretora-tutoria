package br.com.corretora;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import br.com.corretora.dao.AplicacaoDao;
import br.com.corretora.dao.ContaDao;
import br.com.corretora.dao.InvestimentoDao;
import br.com.corretora.dao.UsuarioDao;
import br.com.corretora.modelo.Aplicacao;
import br.com.corretora.modelo.Conta;
import br.com.corretora.modelo.Investimento;
import br.com.corretora.modelo.TipoDeInvestimento;
import br.com.corretora.modelo.Usuario;

public class Principal {

	public static void main(String... args) throws SQLException {
		
		Connection connection = new ConnectionFactory().getConnection();
		
		ContaDao contaDao = new ContaDao(connection);
		UsuarioDao usuarioDao = new UsuarioDao(connection);
		AplicacaoDao aplicacaoDao = new AplicacaoDao(connection);
		InvestimentoDao investimentoDao = new InvestimentoDao(connection);
		
		// usuario 1 com 2 contas
		Usuario pedro = usuarioDao.salva(new Usuario("pedro", "pedro@abc.com", "4321"));
		Conta conta = contaDao.salva(new Conta(pedro, "901-4", 10000.0));
		Conta conta2 = contaDao.salva(new Conta(pedro, "973-7", 20000.0));
		
		LocalDate dataInicial = LocalDate.of(2015, 3, 22);

		Investimento cdb = investimentoDao.salva(new Investimento(1000.0, dataInicial, 0.10, TipoDeInvestimento.CDB));
		Investimento lci = investimentoDao.salva(new Investimento(3000.0, dataInicial, 0.06, TipoDeInvestimento.LCI));

		// usuario 2 com 1 conta
		Usuario joana = usuarioDao.salva(new Usuario("joana", "joana@abc.com", "5321"));
		Conta conta3 = contaDao.salva(new Conta(joana, "243-5", 19600.0));
		
		LocalDate dataInicial2 = LocalDate.of(2014, 4, 12);

		Investimento cdb2 = investimentoDao.salva(new Investimento(2400.0, dataInicial2, 0.12, TipoDeInvestimento.CDB));
		Investimento lci2 = investimentoDao.salva( new Investimento(1000.0, dataInicial2, 0.07, TipoDeInvestimento.LCI));
		
		Aplicacao aplicacao = conta.investe(cdb2);
		aplicacaoDao.salva(aplicacao);
		Aplicacao aplicacao1 = conta2.investe(lci);
		aplicacaoDao.salva(aplicacao1);
		
		
		Aplicacao aplicacao2 = conta3.investe(cdb);
		aplicacaoDao.salva(aplicacao2);
		Aplicacao aplicacao3 = conta3.investe(lci2);
		aplicacaoDao.salva(aplicacao3);
		
		connection.close();
	}
}
