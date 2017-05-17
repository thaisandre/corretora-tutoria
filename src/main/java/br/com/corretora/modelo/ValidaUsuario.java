package br.com.corretora.modelo;

import java.util.HashSet;
import java.util.Set;

public class ValidaUsuario {

	private static Set<String> mensagens = new HashSet<String>();
	
	public Set<String> getMensagens() {
		return mensagens;
	}
	
	public static boolean valida(String nome, String login, String senha) {
		try{
			validaTexto(nome);
		} catch(IllegalArgumentException e) {
			mensagens.add(e.getMessage());
		}
		try{
			validaTexto(login);
		}catch(IllegalArgumentException e) {
			mensagens.add(e.getMessage());
		}
		try{
			validaTexto(senha);
		} catch (IllegalArgumentException e) {
			mensagens.add(e.getMessage());
		}
		if(mensagens.isEmpty()){
			return true;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	private static void validaTexto(String texto) {
		if(texto == null || texto.isEmpty()) {
			throw new IllegalArgumentException("campo " + texto + " deve ser preenchido");
		}
	}
}
