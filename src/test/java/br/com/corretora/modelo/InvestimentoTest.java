package br.com.corretora.modelo;

import static org.mockito.Mockito.mock;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

public class InvestimentoTest {
	
	@Mock
	Investimento mockedInvestimento = mock(Investimento.class);
	
	@Test(expected = IllegalArgumentException.class)
	public void investimentoNaoPodeTerTipoNulo() {
		new Investimento(null, 0.11, 24, 1000.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void investimentoNaoPodeTerTaxaDeJurosNula() {
		new Investimento(TipoDeInvestimento.LCI, null, 24, 1000.0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void investimentoNaoPodeTerPrazoNulo() {
		new Investimento(TipoDeInvestimento.CDB, 0.09, null, 1000.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void investimentoNaoPodeTerValorNulo() {
		new Investimento(TipoDeInvestimento.CDB, 0.11, 24, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void investimentoNaoPodeTerTipoETaxaDeJurosNulos() {
		new Investimento(null, null, 24, 1000.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void investimentoNaoPodeTerTipoEPrazoNulos() {
		new Investimento(null, 0.11, null, 1000.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void investimentoNaoPodeTerTipoEValorNulos() {
		new Investimento(null, 0.10, 24, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void investimentoNaoPodeTerTaxaDeJurosEPrazoNulos() {
		new Investimento(TipoDeInvestimento.CDB, null, null, 1000.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void investimentoNaoPodeTerTaxaDeJurosEValorNulos() {
		new Investimento(TipoDeInvestimento.LCI, null, 24, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void investimentoNaoPodeTerPrazoEValorNulos() {
		new Investimento(TipoDeInvestimento.LCI, 0.1,  null, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void investimentoNaoPodeTerTipoEETaxaDeJurosEPrazoNulos() {
		new Investimento(null, null, null, 1000.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void investimentoNaoPodeTerTipoEprazoEValorNulos() {
		new Investimento(null, 0.11, null, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void investimentoNaoPodeTerTipoETaxaDeJurosEValorNulos() {
		new Investimento(null, null, 24, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void investimentoNaoPodeTerTaxaDeJurosEPrazoEValorNulos() {
		new Investimento(TipoDeInvestimento.CDB, null, null, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void investimentoNaoPodeTerArgumentosNulos() {
		new Investimento(null, null, null, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void investimentoNaoPodeTerValorMinimoNegativo() {
		new Investimento(TipoDeInvestimento.LCI, 0.11, 24, -10.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void investimentoNaoPodeTerPrazoNegativo() {
		new Investimento(TipoDeInvestimento.LCI, 0.11, -1, 1000.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void investimentoNaoPodeTerTaxaDeJurosNegativa() {
		new Investimento(TipoDeInvestimento.LCI, -0.11, 24, 1000.0);
	}
	
	@Test
	public void rentabilidadeMensalDeveSerDE() {
		Investimento investimento = new Investimento(TipoDeInvestimento.CDB, 0.10, 24, 1000.0);
		Assert.assertEquals(0.007974, investimento.getRentabilidadeMensal(), 0.000001);
	}
}
