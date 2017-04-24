package br.com.corretora.modelo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import br.com.corretora.dao.AplicacaoDao;

public class AplicacaoTest {
	
	private Investimento investimento;
	
	@Mock
	AplicacaoDao mockedDao = mock(AplicacaoDao.class);
	
	@Before
	public void setUp() {
		this.investimento = new Investimento(1000.0, LocalDate.now(), 0.1, TipoDeInvestimento.CDB);
	}
	
	@Test(expected = NullPointerException.class)
	public void aplicacaoNaoPodeTerContaNula() {
		new Aplicacao(null,investimento);
	}
	
	@Test(expected = NullPointerException.class)
	public void aplicacaoNaoPodeTerInvestimentoNulo() {
		new Aplicacao(new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-10", 20000.0), null);
	}
	
	@Test(expected = NullPointerException.class)
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
		Conta conta = new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-12", 1000.0);
		Investimento investimento1 = new Investimento(2000.0, LocalDate.now().minusYears(2), 0.10, TipoDeInvestimento.LCI);
		
		Aplicacao aplicacao = new Aplicacao(conta, investimento1);
		Assert.assertEquals(true, aplicacao.resgata());
	}
	
	@Test(expected=RuntimeException.class)
	public void contaNaoPodeTerMaisDoQueCincoAplicacoes() {

		Corretora corretora = new Corretora(mockedDao);
				
		Conta conta = new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-13", 40000.0);
		when(mockedDao.getInvestimentosPor(conta)).thenReturn(Arrays.asList(investimento, investimento, investimento, investimento, investimento));
		
		corretora.aplica(conta, investimento);
	}
	
	@Test
	public void deveDeixarUmaContaTerCincoAplicacoes() {
		Corretora corretora = new Corretora(mockedDao);
		
		
		Conta conta = new Conta(new Usuario("joao", "joao@abc.com", "1234"), "1234-14", 10000.0);
		when(mockedDao.getInvestimentosPor(conta)).thenReturn(Arrays.asList(investimento, investimento, investimento, investimento));
		
		Aplicacao aplicacao = corretora.aplica(conta, investimento);
		
		Assert.assertEquals(conta, aplicacao.getConta());
		Assert.assertEquals(9000.0, aplicacao.getConta().getSaldo(), 0.00001);
	}
}
