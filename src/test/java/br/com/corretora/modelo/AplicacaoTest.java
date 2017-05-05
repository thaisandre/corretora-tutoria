package br.com.corretora.modelo;


import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AplicacaoTest {
	
	private Investimento investimento;
	
	@Before
	public void setUp() {
		this.investimento = new Investimento(1000.0, LocalDate.now(), 0.1, TipoDeInvestimento.CDB);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void aplicacaoNaoPodeTerContaNula() {
		new Aplicacao(null,investimento);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void aplicacaoNaoPodeTerInvestimentoNulo() {
		new Aplicacao(new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-10", 20000.0), null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void aplicacaoNaoPodeTerContaEInvestimentoNulos() {
		new Aplicacao(null, null);
	}
	
	@Test(expected = RuntimeException.class)
	public void NaoPodeResgatarAplicacaoComDuracaoMenorDoQue2anos() {
		
		Conta conta = new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-11", 20000.0);
		Investimento investimento1 = new Investimento(1000.0, LocalDate.now().minusYears(1), 0.11, TipoDeInvestimento.CDB);
		
		Aplicacao aplicacao = new Aplicacao(conta, investimento1);
		
		aplicacao.resgata();
	}
	
	@Test
	public void devePermitirResgatar() {
		Conta conta = new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-12", 10000.0);
		Investimento investimento1 = new Investimento(2000.0, LocalDate.now().minusYears(2), 0.10, TipoDeInvestimento.LCI);
		
		Aplicacao aplicacao = new Aplicacao(conta, investimento1);
		Assert.assertEquals(true, aplicacao.resgata());
	}
}
