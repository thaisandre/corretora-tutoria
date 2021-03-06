package br.com.corretora.modelo;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
	
	@Test 
	public void corretoraDeveTerZeroInvestimentos() {
		assertEquals(0, corretora.getInvestimentos().size());
	}
	
	@Test(expected=RuntimeException.class)
	public void contaNaoPodeTerMaisDoQueCincoAplicacoes() {

		Corretora corretora = new Corretora(mockedDao);
		Investimento investimento = new Investimento(TipoDeInvestimento.CDB, 0.1, 24, 100.0);
				
		Conta conta = new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-13", 40000.0);
		when(mockedDao.getInvestimentosPor(conta)).thenReturn(Arrays.asList(investimento, investimento, investimento, investimento, investimento));
		
		corretora.aplica(conta, investimento, 1000.0);
	}
	
	@Test
	public void deveDeixarUmaContaTerCincoAplicacoes() {
		Corretora corretora = new Corretora(mockedDao);
		Investimento investimento = new Investimento(TipoDeInvestimento.CDB, 0.11, 24, 100.0);
		
		Conta conta = new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-14", 10000.0);
		when(mockedDao.getInvestimentosPor(conta)).thenReturn(Arrays.asList(investimento, investimento, investimento, investimento));
		
		Investimento investimento2 = new Investimento(TipoDeInvestimento.LCI, 0.12, 30, 100.0);
		Aplicacao aplicacao = corretora.aplica(conta, investimento2, 1000.0);
		
		Assert.assertEquals(conta, aplicacao.getConta());
		Assert.assertEquals(9000.0, aplicacao.getConta().getSaldo(), 0.00001);
	}
}
