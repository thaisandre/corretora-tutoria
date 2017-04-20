package br.com.corretora.modelo;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class InvestimentoTest {

	@Test(expected = NullPointerException.class)
	public void investimentoNaoPodeTerValorNulo() {
		new Investimento(null, LocalDate.now(), 0.11, TipoDeInvestimento.CDB);
	}

	@Test(expected = NullPointerException.class)
	public void investimentoNaoPodeTerDataNula() {
		new Investimento(1000.0, null, 0.11, TipoDeInvestimento.CDB);
	}

	@Test(expected = NullPointerException.class)
	public void investimentoNaoPodeTerTaxaDeJurosNula() {
		new Investimento(1000.0, LocalDate.now(), null, TipoDeInvestimento.CDB);
	}

	@Test(expected = NullPointerException.class)
	public void investimentoNaoPodeTerTipoNulo() {
		new Investimento(1000.0, LocalDate.now(), 0.11, null);
	}

	@Test(expected = NullPointerException.class)
	public void investimentoNaoPodeTerValorEDataNulos() {
		new Investimento(null, null, 0.11, TipoDeInvestimento.CDB);
	}

	@Test(expected = NullPointerException.class)
	public void investimentoNaoPodeTerValorETaxaDeJurosNulos() {
		new Investimento(null, LocalDate.now(), null, TipoDeInvestimento.CDB);
	}

	@Test(expected = NullPointerException.class)
	public void investimentoNaoPodeTerValorETipoNulos() {
		new Investimento(null, LocalDate.now(), 0.11, null);
	}

	@Test(expected = NullPointerException.class)
	public void investimentoNaoPodeTerDataETaxaDeJurosNulos() {
		new Investimento(1000.0, null, null, TipoDeInvestimento.CDB);
	}

	@Test(expected = NullPointerException.class)
	public void investimentoNaoPodeTerDataETipoNulos() {
		new Investimento(1000.0, null, 0.11, null);
	}

	@Test(expected = NullPointerException.class)
	public void investimentoNaoPodeTerTaxaDeJurosETipoNulos() {
		new Investimento(1000.0, LocalDate.now(), null, null);
	}

	@Test(expected = NullPointerException.class)
	public void investimentoNaoPodeTerValorEDataETaxaDeJurosNulos() {
		new Investimento(null, null, null, TipoDeInvestimento.CDB);
	}

	@Test(expected = NullPointerException.class)
	public void investimentoNaoPodeTerValorETaxaDeJurosETipoNulos() {
		new Investimento(null, LocalDate.now(), null, null);
	}

	@Test(expected = NullPointerException.class)
	public void investimentoNaoPodeTerValorEDataETipoNulos() {
		new Investimento(null, null, 0.11, null);
	}

	@Test(expected = NullPointerException.class)
	public void investimentoNaoPodeTerDataETaxaDeJurosETipoNulos() {
		new Investimento(1000.0, null, null, null);
	}

	@Test(expected = NullPointerException.class)
	public void investimentoNaoPodeTerValorEDataETaxaDeJurosETipoNulos() {
		new Investimento(null, null, null, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void investimentoNaoPodeTerValorNegativo() {
		new Investimento(-10.0, LocalDate.now(), 0.11, TipoDeInvestimento.LCI);
	}

	@Test(expected = IllegalArgumentException.class)
	public void investimentoNaoPodeTerValorMenorDoQue1000() {
		new Investimento(999.9, LocalDate.now(), 0.11, TipoDeInvestimento.LCI);
	}

	@Test(expected = IllegalArgumentException.class)
	public void investimentoNaoPodeTerTaxaDeJurosNegativa() {
		new Investimento(1000.0, LocalDate.now(), -0.11, TipoDeInvestimento.LCI);
	}
	
	@Test
	public void duracaoDeveSerDeUmMes() {
		Investimento investimento = new Investimento(1000.0, LocalDate.now().minusMonths(1), 0.11, TipoDeInvestimento.CDB);
		Assert.assertEquals(1, investimento.getIntervalo(), 0.000001);
	}
	
	@Test
	public void resgateDeveSer() {
		Investimento investimento = new Investimento(1000.0, LocalDate.now().minusYears(2), 0.11, TipoDeInvestimento.CDB);
		Assert.assertEquals(1185.68, investimento.getTotalResgate(), 0.000001);
	}
	
	
}