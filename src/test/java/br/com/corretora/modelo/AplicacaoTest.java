package br.com.corretora.modelo;


import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AplicacaoTest {
	
	private Usuario usuario;
	private Investimento investimento;
	
	@Before
	public void setUp() {
		this.usuario = new Usuario("joao", "joao@abc.com", "1234");
		this.investimento = new Investimento(TipoDeInvestimento.CDB, 0.1, 24, 1000.0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void aplicacaoNaoPodeTerContaNula() {
		new Aplicacao(null,investimento, LocalDate.now(), 2000.0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void aplicacaoNaoPodeTerInvestimentoNulo() {
		new Aplicacao(new Conta(usuario, "1234-10", 20000.0), null, LocalDate.now(), 2000.0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void aplicacaoNaoPodeTerDataNula() {
		new Aplicacao(new Conta(usuario, "1234-11", 20000.0), investimento, null, 2000.0);
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void aplicacaoNaoPodeTerValorNulo() {
		new Aplicacao(new Conta(usuario, "1234-12", 20000.0), investimento, LocalDate.now(), null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void aplicacaoNaoPodeTerContaEInvestimentoNulos() {
		new Aplicacao(null, null, LocalDate.now(), 2000.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void aplicacaoNaoPodeTerContaEDataNulas() {
		new Aplicacao(null, investimento, null, 2000.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void aplicacaoNaoPOdeTerContaEValorNulos() {
		new Aplicacao(null, investimento, LocalDate.now(), null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void aplicacaoNaoPodeTerInvestimentoEDataNulos() {
		new Aplicacao(new Conta(usuario, "1234-13", 20000.0), null, null, 2000.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void aplicacaoNaoPodeTerInvestimentoEValorNulos() {
		new Aplicacao(new Conta(usuario, "1234-14", 20000.0), null, LocalDate.now(), null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void aplicacaoNaoPodeTerDataEValorNulos() {
		new Aplicacao(new Conta(usuario, "1234-15", 20000.0), investimento, null, null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void aplicacaoNaoPodeterContaInvestimentoEDataNulos() {
		new Aplicacao(null, null, null, 2000.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void aplicacaoNaoPodeterContaInvestimentoEValorNulos() {
		new Aplicacao(null, null, LocalDate.now(), null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void aplicacaoNaoPodeterContaValorEDataNulos() {
		new Aplicacao(null, investimento, null, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void aplicacaoNaoPodeterInvestimentoValorEDataNulos() {
		new Aplicacao(new Conta(usuario, "1234-16", 20000.0), null, null, null);
	}
	
	@Test(expected = RuntimeException.class)
	public void NaoPodeResgatarAplicacaoComDuracaoAntesDoPrazoDoInvestimento() {
		
		Conta conta = new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-17", 20000.0);
		Investimento investimento1 = new Investimento(TipoDeInvestimento.CDB, 0.11, 24, 1000.0);
		
		Aplicacao aplicacao = new Aplicacao(conta, investimento1, LocalDate.now(), 1000.0);
		
		aplicacao.resgata();
	}
	
	@Test
	public void devePermitirResgatar() {
		Conta conta = new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-18", 10000.0);
		Investimento investimento1 = new Investimento(TipoDeInvestimento.LCI, 0.11, 24, 1000.0);
		
		Aplicacao aplicacao = new Aplicacao(conta, investimento1, LocalDate.now().minusYears(2), 2000.0);
		Assert.assertEquals(true, aplicacao.resgata());
	}
}
