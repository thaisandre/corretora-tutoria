package br.com.corretora;

import br.com.corretora.modelo.Conta;
import br.com.corretora.modelo.Usuario;

public class TesteUsuario {

	public static void main(String[] args) {
		System.out.println("testeCriaroUsuarioComContaNula() " + (testeCriaroUsuarioComContaNula() ? "Passou!" : "Falhou!"));
	
	}
	
	private static boolean testeCriaroUsuarioComContaNula() {
		try {
			Conta conta = null;
			Usuario usuario = new Usuario(conta);
		} catch (NullPointerException e) {
			System.out.println("conta não pode ser nula");
		}

		return true;
	}

}
