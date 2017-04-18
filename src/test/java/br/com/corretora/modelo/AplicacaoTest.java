package br.com.corretora.modelo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.corretora.dao.AplicacaoDao;
import br.com.corretora.dao.AplicacaoDaoDeMentira;

public class AplicacaoTest {
	
	Investimento investimento;
	AplicacaoDao dao;
	
	@Before
	public void setUp() {
		this.investimento = new Investimento(10000.0, LocalDate.now(),0.1, TipoDeInvestimento.CDB);
		this.dao = new AplicacaoDaoDeMentira(Arrays.asList(investimento));
	}
	
	@After
	public void close() throws SQLException {
		//connection.close();
	}
	
	@Test(expected = NullPointerException.class)
	public void aplicacaoNaoPodeTerContaNula() {
		new Aplicacao(null,investimento);
	}
	
	@Test(expected = NullPointerException.class)
	public void aplicacaoNaoPodeTerInvestimentoNulo() {
		new Aplicacao(new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-10", 20000.0, dao), null);
	}
	
	@Test(expected = NullPointerException.class)
	public void aplicacaoNaoPodeTerContaEInvestimentoNulos() {
		new Aplicacao(null, null);
	}
	
	@Test(expected = RuntimeException.class)
	public void NaoPodeResgatarAplicacaoComDuracaoMenorDoQue2anos() {
		Conta conta = new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-11", 10000.0, dao);
		Investimento investimento = new Investimento(2000.0, LocalDate.now().minusYears(1), 0.11, TipoDeInvestimento.CDB);
		
		Aplicacao aplicacao = new Aplicacao(conta, investimento);
		aplicacao.resgata();
	}
	
	@Test
	public void devePermitirResgatar() {
		Conta conta = new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-12", 1000.0, dao);
		Investimento investimento = new Investimento(2000.0, LocalDate.now().minusYears(2), 0.10, TipoDeInvestimento.LCI);
		
		Aplicacao aplicacao = new Aplicacao(conta, investimento);
		Assert.assertEquals(true, aplicacao.resgata());
	}
	
	@Test(expected=RuntimeException.class)
	public void contaNaoPodeTerMaisDoQueCincoAplicacoes() {
		
		AplicacaoDao dao1 = new AplicacaoDaoDeMentira(Arrays.asList(investimento, investimento, investimento, investimento, investimento));
		Conta conta = new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-13", 10000.0, dao1);
		
		Aplicacao aplicacao = conta.investe(investimento);
		
	}
	
	@Test
	public void deveDeixarUmaContaTerCincoAplicacoes() {
		AplicacaoDao dao2 = new AplicacaoDaoDeMentira(Arrays.asList(investimento, investimento, investimento, investimento, investimento));
		Conta conta = new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-14", 10000.0, dao2);
	}

}
