package br.com.corretora;

import java.time.LocalDate;

import br.com.corretora.modelo.CDB;
import br.com.corretora.modelo.Conta;
import br.com.corretora.modelo.Usuario;

public class TesteUsuario {

	public static void main(String[] args) {
		
	
	}
	
	private static boolean testeCriacaoUsuario() {
		try {
			Conta conta = new Conta(1000.0);
			Usuario usuario = new Usuario(conta);
		} catch (IllegalArgumentException e) {
			System.out.println("argumento inválido - o valor não pode ser menor do que o mínimo(1000.0)");
		}

		return true;
	}

}
