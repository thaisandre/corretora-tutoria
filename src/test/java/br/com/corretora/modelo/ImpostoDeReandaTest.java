package br.com.corretora.modelo;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ImpostoDeReandaTest {
	
	Desconto imposto;
	
	@Before
	@Test
	public void setUp() {
		this.imposto = new ImpostoDeRenda();
	}
	
	@Test
	public void ImpostoDeveSerVinteECincoPorcento() {
		Investimento investimento = new Investimento(1000.0, LocalDate.now().minusYears(1), 0.10, TipoDeInvestimento.CDB);
		Investimento investimento2 = new Investimento(1000.0, LocalDate.now().minusMonths(1), 0.10, TipoDeInvestimento.CDB);
		
		Assert.assertEquals(0.25, imposto.getValor(investimento), 0.000001);
		Assert.assertEquals(0.25, imposto.getValor(investimento2), 0.00001);
	}
	
	public void ImpostoDeveSerVintePorCento() {
		Investimento investimento = new Investimento(1000.0, LocalDate.now().minusYears(2), 0.10, TipoDeInvestimento.CDB);
		Investimento investimento2 = new Investimento(1000.0, LocalDate.now().minusMonths(13), 0.10, TipoDeInvestimento.CDB);
		
		Assert.assertEquals(0.20, imposto.getValor(investimento), 0.000001);
		Assert.assertEquals(0.20, imposto.getValor(investimento2), 0.000001);
		
	}
	
	public void ImpostoDeveSerQuinzePorCento() {
		Investimento investimento = new Investimento(1000.0, LocalDate.now().minusYears(3), 0.10, TipoDeInvestimento.CDB);
		Investimento investimento2 = new Investimento(1000.0, LocalDate.now().minusMonths(25), 0.10, TipoDeInvestimento.CDB);
		
		Assert.assertEquals(0.15, imposto.getValor(investimento), 0.000001);
		Assert.assertEquals(0.15, imposto.getValor(investimento2), 0.00001);
		
	}

}
