package br.com.corretora.testes;


import br.com.corretora.modelo.Conta;
import br.com.corretora.modelo.Usuario;

public class TestaConta {

	public static void main(String[] args) {
		System.out.println("testaCriarContaComUsuarioNulo() " + (testaCriarContaComUsuarioNulo() ? "Passou!" : "Falhou!"));
		System.out.println("testaCriarContaComNumeroNulo() " + (testaCriarContaComNumeroNulo() ? "Passou!" : "Falhou!"));
		System.out.println("testaCriarContaComSaldoNulo() " + (testaCriarContaComSaldoNulo() ? "Passou!" : "Falhou!"));
		System.out.println("testaCriarContaComSaldoNegativo() " + (testaCriarContaComSaldoNegativo()  ? "Passou!" : "Falhou!"));
		System.out.println("testaMetodoInvesteComInvestimentoNulo() " + (testaMetodoInvesteComInvestimentoNulo() ? "Passou!" : "Falhou!"));
	}
	
	
	private static boolean testaCriarContaComUsuarioNulo() {
		try {
			Conta conta = new Conta(null, "123-4", 1000.0);
		} catch (NullPointerException e) {
			System.out.println("Usuario não pode ser nulo");
		}
		return true;
	}
	
	private static boolean testaCriarContaComNumeroNulo() {
		try {
			Conta conta = new Conta(new Usuario("joao", "joao@abc.com", "1234"), null, 1000.0);
		} catch (NullPointerException e) {
			System.out.println("Numero não pode ser nulo");
		}
		return true;
	}
	
	private static boolean testaCriarContaComSaldoNulo() {
		try {
			Conta conta = new Conta(new Usuario("joao", "joao@abc.com", "1234"), "123-4", null);
		} catch (NullPointerException e) {
			System.out.println("Numero não pode ser nulo");
		}
		return true;
	}
	
	private static boolean testaCriarContaComSaldoNegativo() {
		try {
			Conta conta = new Conta(new Usuario("joao", "joao@abc.com", "1234"), "123-4", -10.0);
		} catch (IllegalArgumentException e) {
			System.out.println("Saldo não pode ser negativo");
		}
		
		return true;
	}
	
	private static boolean testaMetodoInvesteComInvestimentoNulo() {
		try {
			Conta conta  = new Conta(new Usuario("joao", "joao@abc.com", "1234"), "123-4", 1000.0);
			//Investimento investimento = new Investimento(1000.0, LocalDate.of(2016, 1, 1), 0.10, TipoDeInvestimento.CDB);
			conta.investe(null);
		} catch (NullPointerException e) {
			System.out.println("operação inválida - investimento não pode ser nulo.");
		}
		return true;
	}
	
}
