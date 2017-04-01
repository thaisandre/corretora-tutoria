package br.com.corretora;

import java.time.LocalDate;

import br.com.corretora.modelo.CDB;

public class TestaCDB {
	
	public static void main(String[] args) {
		
		System.out.println("testeDeCriacaoDeCDB " + (testeDeCriacaoDeCDB() ? "Passou!" : "Falhou!"));
		System.out.println("testaDataNoPassado " + (testaDataNoPassado() ? "Passou" : "Falhou!"));
		System.out.println("testaValorMenorDoQueMinimo()" + (testaValorMenorDoQueMinimo() ? "Passou" : "Falhou!"));
		System.out.println("testaDataNoPassadoEValorMinimo " + (testaDataNoPassadoEValorMinimo() ? "Passou!" : "Falhou!"));
		System.out.println("testaValorNulo() " + (testaValorNulo() ? "Passou!" : "Falhou!"));
		System.out.println("testaDataNula() " + (testaDataNula() ? "Passou!" : "Falhou!"));
		System.out.println("testaValorEDataNulos() " + (testaValorEDataNulos() ? "Passou!" : "Falhou!"));
	}

	private static boolean testeDeCriacaoDeCDB() {

		try {
			CDB cdb1 = new CDB(10000.0, LocalDate.of(2018, 1, 1));
		} catch (IllegalArgumentException e) {
			System.out.println("argumento inválido - o valor");
		}

		return true;

	}

	private static boolean testaDataNoPassado() {

		try {
			CDB cdb1 = new CDB(1000.0, LocalDate.of(2016, 1, 1));
		} catch (IllegalArgumentException e) {
			System.out.println("argumento inválido - a data Inicial não pode ser no passado");
		}

		return true;

	}

	private static boolean testaValorMenorDoQueMinimo() {

		try {
			CDB cdb1 = new CDB(500.0, LocalDate.of(2018, 1, 1));
		} catch (IllegalArgumentException e) {
			System.out.println("argumento inválido - o valor não pode ser menor do que o mínimo(1000.0)");
		}

		return true;

	}

	private static boolean testaDataNoPassadoEValorMinimo() {

		try {
			CDB cdb1 = new CDB(500.0, LocalDate.of(2016, 1, 1));
		} catch (IllegalArgumentException e) {
			System.out.println("argumento inválido - a data Inicial não pode ser no passado e o"
					+ "valor não pode ser menor do que 0 mínimo(1000.0)");
		}

		return true;

	}
	
	private static boolean testaValorNulo() {

		try {
			Double valor = null;
			CDB cdb1 = new CDB(null, LocalDate.of(2018, 1, 1));
		} catch (NullPointerException e) {
			System.out.println("o valor não pode ser nulo");
		}

		return true;
	}
	
	private static boolean testaDataNula() {

		try {
			LocalDate dataInicial = null;
			CDB cdb1 = new CDB(1000.0, dataInicial);
		} catch (NullPointerException e) {
			System.out.println("o valor não pode ser nulo");
		}

		return true;
	}
	
	private static boolean testaValorEDataNulos() {

		try {
			Double valor = null;
			LocalDate dataInicial = null;
			CDB cdb1 = new CDB(null, dataInicial);
		} catch (NullPointerException e) {
			System.out.println("o valor e a data não podem ser nulos");
		} 

		return true;
	}
	

}
