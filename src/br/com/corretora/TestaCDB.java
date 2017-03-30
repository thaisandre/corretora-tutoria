package br.com.corretora;

import java.time.LocalDate;

import br.com.corretora.modelo.CDB;

public class TestaCDB {
	
	public static void main(String[] args) {
		
		System.out.println("testeDeCriacaoDeCDB " + (testeDeCriacaoDeCDB() ? "Passou!" : "Falhou!"));
		System.out.println("testaDataNoPassado " + (testaDataNoPassado() ? "Passou" : "Falhou!"));
		System.out.println("testaValorMenorDoQueMinimo()" + (testaValorMenorDoQueMinimo() ? "Passou" : "Falhou!"));
		System.out.println("testaDataNoPassadoEValorMinimo " + (testaDataNoPassadoEValorMinimo() ? "Passou!" : "Falhou!"));
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

}
