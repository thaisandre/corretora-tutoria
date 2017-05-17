package br.com.corretora.modelo;

import java.util.HashSet;
import java.util.Set;

public class ValidaTexto {

	private Set<String> mensagens = new HashSet<String>();

	public Set<String> getMensagens() {
		return mensagens;
	}

	public ErroValidacao valida(String valor, String campo) {
		String mensagem = null;
			if (valor == null || valor.isEmpty()){
				mensagem = "campo " + campo + " deve ser preenchido";
			}
		return new ErroValidacao(mensagem, campo, valor);
	}
}
