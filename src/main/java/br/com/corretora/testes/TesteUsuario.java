package br.com.corretora;

import br.com.corretora.modelo.Conta;
import br.com.corretora.modelo.Usuario;

public class TesteUsuario {

	public static void main(String[] args) {
		System.out.println("testeCriarUsuarioComContaNula() " + (testeCriarUsuarioComContaNula() ? "Passou!" : "Falhou!"));
		System.out.println("testeCriarUsuarioComNomeNulo() " + (testeCriarUsuarioComNomeNulo() ? "Passou!" : "Falhou!"));
	}
	
	private static boolean testeCriarUsuarioComContaNula() {
		try {
			Conta conta = null;
			Usuario usuario = new Usuario("maria", conta);
		} catch (NullPointerException e) {
			System.out.println("conta não pode ser nula");
		}
		return true;
	}
	
	private static boolean testeCriarUsuarioComNomeNulo() {
		try {
			Conta conta = new Conta(1000.0);
			String nome = null;
			Usuario usuario = new Usuario(nome, conta);
		} catch (NullPointerException e) {
			System.out.println("nome não pode ser nulo");
		}
		return true;
	}
}
