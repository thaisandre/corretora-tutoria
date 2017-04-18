package br.com.corretora.modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.corretora.ConnectionFactory;
import br.com.corretora.dao.AplicacaoDao;

public class ContaTest {
	
	Connection connection;
	
	@Before
	public void setUp() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	@After
	public void close() throws SQLException {
		connection.close();
	}

	@Test(expected = NullPointerException.class)
	public void contaNaoPodeTerUsuarioNulo() {
		new Conta(null, "1234-0", 10.0, new AplicacaoDao(connection));
	}

	@Test(expected = NullPointerException.class)
	public void contaNaoPodeTerSaldoNulo() {
		new Conta(new Usuario("joao", "joao@abc.com", "1235"), "1234-0", null, new AplicacaoDao(connection));
	}

	@Test(expected = NullPointerException.class)
	public void contaNaoPodeTerNumeroNulo() {
		new Conta(new Usuario("joao", "joao@abc.com", "1235"), null, 10.0, new AplicacaoDao(connection));
	}

	@Test(expected = NullPointerException.class)
	public void contaNaoPodeTerUsuarioENumeroNulos() {
		new Conta(null, null, 10.0, new AplicacaoDao(connection));
	}

	@Test(expected = NullPointerException.class)
	public void contaNaoPodeTerUsuarioESaldoNulos() {
		new Conta(null, "1234-2", null, new AplicacaoDao(connection));
	}

	@Test(expected = NullPointerException.class)
	public void contaNaoPodeTerNumeroESaldoNulos() {
		new Conta(new Usuario("joao", "joao@abc.com", "1234"), null, null, new AplicacaoDao(connection));
	}

	@Test(expected = NullPointerException.class)
	public void contaNaoPodeTerUsuarioESaldoENumeronulos() {
		new Conta(null, null, null, new AplicacaoDao(connection));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarContaComSaldoNegativo() {
		new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-1", -10.0, new AplicacaoDao(connection));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarContaComSaldoIgualAZero() {
		new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-2", 0.0, new AplicacaoDao(connection));
	}
	
	@Test
	public void saldoDeveSerMil() {
		Conta conta = new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-3", 10000.0, new AplicacaoDao(connection));
		conta.deposita(500.0);
		Assert.assertEquals(10500.0, conta.getSaldo(), 0.00001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void valorDoDepositoNaoPodeSerNegativo() {
		Conta conta = new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-4", 10000.0, new AplicacaoDao(connection));
		conta.deposita(-10.0);
	}

	@Test
	public void saldoDaContaDeveSerNoveMil() {
		Conta conta = new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-5", 10000.0, new AplicacaoDao(connection));
		Investimento investimento = new Investimento(1000.0, LocalDate.of(2014, 1, 1), 0.11, TipoDeInvestimento.CDB);
		
		Aplicacao aplicacao = conta.investe(investimento);
		Assert.assertEquals(9000.0, aplicacao.getConta().getSaldo(), 0.000001);
	}
	
	@Test
	public void saldoDaContaDeveSerZero() {
		Conta conta = new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-6", 10000.0, new AplicacaoDao(connection));
		Investimento investimento = new Investimento(10000.0, LocalDate.of(2014, 1, 1), 0.11, TipoDeInvestimento.LCI);
		
		Aplicacao aplicacao = conta.investe(investimento);
		Assert.assertEquals(0.0, aplicacao.getConta().getSaldo(), 0.000001);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDevePermitirInvestirValorMaiorDoQueSaldo() {
		Conta conta = new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-7", 10000.0, new AplicacaoDao(connection));
		Investimento investimento = new Investimento(10001.0, LocalDate.of(2014, 1, 1), 0.11, TipoDeInvestimento.LCI);
		
		Aplicacao aplicacao = conta.investe(investimento);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDevePermitirCriacaoDeContaComNumeroExistente() {
		Conta conta = new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-0", 10000.0, new AplicacaoDao(connection));
		Conta conta1 = new Conta(new Usuario("maria", "maria@abc.com", "1234"), "1234-0", 12000.0, new AplicacaoDao(connection));
	}
}
