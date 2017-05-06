package br.com.corretora.modelo;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import br.com.corretora.dao.AplicacaoDao;

public class CorretoraTest {
	
	private Corretora corretora; 
	
	@Mock
	AplicacaoDao mockedDao = mock(AplicacaoDao.class);
	
	@Before
	public void setUp(){
		corretora = new Corretora(mockedDao);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void daoNaoDeveSerNulo() {
		new Corretora(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDeveDeixarCriarInvestimentoComDataNoPassado() {
		corretora.criaInvestimento(1000.0, LocalDate.now().minusDays(1), 0.11, TipoDeInvestimento.CDB);
	}
	
	@Test
	public void testaCriacaoInvestimento() {
		Investimento investimento = corretora.criaInvestimento(1000.0, LocalDate.now(), 0.11, TipoDeInvestimento.CDB);
		assertEquals(1000.0, investimento.getValor(), 0.000001);
	}
	
	@Test 
	public void corretoraDeveTer2Investimentos() {
		corretora.criaInvestimento(1000.0, LocalDate.now(), 0.11, TipoDeInvestimento.CDB);
		corretora.criaInvestimento(1000.0, LocalDate.now(), 0.10, TipoDeInvestimento.LCI);
		assertEquals(2, corretora.getInvestimentos().size());
	}
	
	@Test 
	public void corretoraDeveTerZeroInvestimentos() {
		assertEquals(0, corretora.getInvestimentos().size());
	}
	
	@Test(expected=RuntimeException.class)
	public void contaNaoPodeTerMaisDoQueCincoAplicacoes() {

		Corretora corretora = new Corretora(mockedDao);
		Investimento investimento = corretora.criaInvestimento(1000.0, LocalDate.now(), 0.10, TipoDeInvestimento.CDB);
				
		Conta conta = new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-13", 40000.0);
		when(mockedDao.getInvestimentosPor(conta)).thenReturn(Arrays.asList(investimento, investimento, investimento, investimento, investimento));
		
		corretora.aplica(conta, investimento);
	}
	
	@Test
	public void deveDeixarUmaContaTerCincoAplicacoes() {
		Corretora corretora = new Corretora(mockedDao);
		Investimento investimento = corretora.criaInvestimento(1000.0, LocalDate.now(), 0.10, TipoDeInvestimento.CDB);
		
		Conta conta = new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-14", 10000.0);
		when(mockedDao.getInvestimentosPor(conta)).thenReturn(Arrays.asList(investimento, investimento, investimento, investimento));
		
		Aplicacao aplicacao = corretora.aplica(conta, investimento);
		
		Assert.assertEquals(conta, aplicacao.getConta());
		Assert.assertEquals(9000.0, aplicacao.getConta().getSaldo(), 0.00001);
	}
}
