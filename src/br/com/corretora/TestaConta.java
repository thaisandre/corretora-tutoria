package br.com.corretora;

import br.com.corretora.modelo.Conta;

public class TestaConta {

	public static void main(String[] args) {
		System.out.println("testaCriarContaComSaldoNegativo() " + (testaCriarContaComSaldoNegativo()  ? "Passou!" : "Falhou!"));
		System.out.println("testaCriarContaSemSaldo() " + (testaCriarContaSemSaldo()  ? "Passou!" : "Falhou!"));
	}
	
	public static boolean testaCriarContaComSaldoNegativo() {
		try {
			Conta conta = new Conta(-10.0);
		} catch (IllegalArgumentException e) {
			System.out.println("Saldo não pode ser negativo");
		}
		
		return true;
	}
	
	public static boolean testaCriarContaSemSaldo() {
		try {
			Double saldo = null;
			Conta conta = new Conta(saldo);
		} catch (NullPointerException e) {
			System.out.println("Saldo não pode ser vazio");
		}
		
		return true;
	}
	
}
