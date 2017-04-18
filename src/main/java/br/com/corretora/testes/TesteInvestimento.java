package br.com.corretora.testes;

import java.time.LocalDate;

import br.com.corretora.modelo.Investimento;
import br.com.corretora.modelo.TipoDeInvestimento;

public class TesteInvestimento {

	public static void main(String[] args) {
		System.out.println("testaDataNOPassado() " + (testaDataNoPassado() ? "Passou!" : "Falhou!"));
		System.out.println("testaDataNula() " + (testaDataNula() ? "Passou!" : "Falhou!"));
		System.out.println("testaValorMenorDoMinimo() " + (testaValorMenorDoMinimo() ? "Passou!" : "Falhou!"));
		System.out.println("testaValorNulo() " + (testaValorNulo() ? "Passou!" : "Falhou!"));
		System.out.println("testaValorMenorDoqueZero() " + (testaValorMenorDoqueZero() ? "Passou!" : "Falhou!"));
		System.out.println("testaTaxaDeJurosMenorDoQueZero() " + (testaTaxaDeJurosMenorDoQueZero() ? "Passou!" : "Falhou!"));
		System.out.println("testaTaxaDeJurosNula() " + (testaTaxaDeJurosNula() ? "Passou!" : "Falhou!"));
		System.out.println("testaTipoNulo() " + (testaTipoNulo() ? "Passou!" : "Falhou!"));
	}

	private static boolean testaDataNoPassado() {
		try {
			Investimento investimento = new Investimento(1000.0, LocalDate.of(2015, 1, 1), 0.11,
					TipoDeInvestimento.CDB);
		} catch (IllegalArgumentException e) {
			System.out.println("operação inválida - a data não pode ser no passado");
		}
		return true;
	}

	private static boolean testaDataNula() {
		try {
			LocalDate dataInicial = null;
			Investimento investimento = new Investimento(500.0, null, 0.11, TipoDeInvestimento.LCI);
		} catch (IllegalArgumentException e) {
			System.out.println("operação inválida - a data não pode ser nula");
		}
		return true;
	}

	private static boolean testaValorMenorDoMinimo() {
		try {
			Investimento investimento = new Investimento(500.0, LocalDate.of(2018, 1, 1), 0.11, TipoDeInvestimento.LCI);
		} catch (IllegalArgumentException e) {
			System.out.println("operação inválida - o valor não pode ser menor do que o mínimo");
		}
		return true;
	}

	private static boolean testaValorNulo() {
		try {
			Double valor = null;
			Investimento investimento = new Investimento(valor, LocalDate.of(2018, 1, 1), 0.11, TipoDeInvestimento.CDB);
		} catch (NullPointerException e) {
			System.out.println("operação inválida -  o valor não pode ser nulo");
		}
		return true;
	}

	private static boolean testaValorMenorDoqueZero() {
		try {
			Investimento investimento = new Investimento(-1.0, LocalDate.of(2018, 1, 1), 0.11, TipoDeInvestimento.LCI);
		} catch (IllegalArgumentException e) {
			System.out.println("operação inválida - o valor deve ser maior do que 0.0");
		}
		return true;
	}

	private static boolean testaTaxaDeJurosMenorDoQueZero() {
		try {
			Investimento investimento = new Investimento(1000.0, LocalDate.of(2018, 1, 1), -0.1,
					TipoDeInvestimento.CDB);
		} catch (IllegalArgumentException e) {
			System.out.println("operação inválida - a taxa de juros deve ser positiva");
		}
		return true;
	}

	private static boolean testaTaxaDeJurosNula() {
		try {
			Double taxaDeJuros = null;
			Investimento investimento = new Investimento(1000.0, LocalDate.of(2018, 1, 1), taxaDeJuros,
					TipoDeInvestimento.CDB);
		} catch (NullPointerException e) {
			System.out.println("a taxa de juros não pode ser nula");
		}
		return true;
	}
	
	private static boolean testaTipoNulo() {
		try {
			TipoDeInvestimento tipo = null;
			Investimento investimento = new Investimento(1000.0, LocalDate.now(), 0.11, tipo);
		} catch (NullPointerException e) {
			System.out.println("operação inválida - o tipo não pode ser nulo");
		}
		return true;
	}

}
