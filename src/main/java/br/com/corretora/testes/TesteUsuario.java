package br.com.corretora.testes;

import br.com.corretora.modelo.Usuario;

public class TesteUsuario {

	public static void main(String[] args) {
		System.out.println("testeCriarUsuarioComNomeNulo() " + (testeCriarUsuarioComNomeNulo() ? "Passou!" : "Falhou!"));
		System.out.println("testeCriarUsuarioComloginNulo() " + (testeCriarUsuarioComLoginNulo() ? "Passou!" : "Falhou!"));
		System.out.println("testeCriarUsuarioComSenhaNula() " + (testeCriarUsuarioComSenhaNula() ? "Passou!" : "Falhou!"));
		System.out.println("testeCriarUsuarioComNomeELoginNulos() " + (testeCriarUsuarioComNomeELoginNulos() ? "Passou!" : "Falhou!" ));
		System.out.println("testeCriarUsuarioComNomeESenhaNulos() " + (testeCriarUsuarioComNomeESenhaNulos() ? "Passou!" : "Falhou!"));
		System.out.println("testeCriarUsuarioComLoginESenhaNulos() " + (testeCriarUsuarioComLoginESenhaNulos() ? "Passou!" : "Falhou!"));
		System.out.println("testeCriarUsuarioComParametrosNulos() " + (testeCriarUsuarioComParametrosNulos() ? "Passou!" : "Falhou!"));
	}
	
	private static boolean testeCriarUsuarioComNomeNulo() {
		try {
			Usuario usuario = new Usuario(null, "nome123", "1235");
		} catch (NullPointerException e) {
			System.out.println("nome não pode ser nulo");
		}
		return true;
	}
	
	private static boolean testeCriarUsuarioComLoginNulo() {
		try {
			Usuario usuario = new Usuario("maria", null, "1234");
		} catch (NullPointerException e) {
			System.out.println("login não pode ser nulo");
		}
		return true;
	}
	
	private static boolean testeCriarUsuarioComSenhaNula() {
		try {
			Usuario usuario = new Usuario("maria", "maria123", null);
		} catch (NullPointerException e) {
			System.out.println("senha não pode ser nula");
		}
		return true;
	}
	private static boolean testeCriarUsuarioComNomeELoginNulos() {
		try {
			Usuario usuario = new Usuario(null, null, "1234");
		} catch (NullPointerException e) {
			System.out.println("nome e login não podem ser nulos");
		}
		return true;
	}
	
	private static boolean testeCriarUsuarioComNomeESenhaNulos() {
		try {
			Usuario usuario = new Usuario(null, "nome123", null);
		} catch (NullPointerException e) {
			System.out.println("nome e senha não podem ser nulos");
		}
		return true;
	}
	
	private static boolean testeCriarUsuarioComLoginESenhaNulos() {
		try {
			Usuario usuario = new Usuario("maria", null, null);
		} catch (NullPointerException e) {
			System.out.println("login e senha não podem ser nulos");
		}
		return true;
	}
	
	private static boolean testeCriarUsuarioComParametrosNulos() {
		try {
			Usuario usuario = new Usuario(null, null, null);
		} catch (NullPointerException e) {
			System.out.println("nome, login e senha não podem ser nulos");
		}
		return true;
	}
	
}
