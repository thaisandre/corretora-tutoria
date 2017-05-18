package br.com.corretora.modelo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class Validador {

	private HttpServletRequest request;
	private Map<String, String> erros = new HashMap<>();

	public Validador(HttpServletRequest request) {
		this.request = request;
	}

	public void verificaNulo(String nomeParametro, String msg) {
		if (request.getParameter(nomeParametro) == null) {
			erros.put(nomeParametro, msg);
		}
	}

	public void verificaNumero(String nomeParametro, String msg) {
		try {
			Double.parseDouble(request.getParameter(nomeParametro));
		} catch (NumberFormatException ex) {
			erros.put(nomeParametro, msg);
		}
	}

	public void verificaNumeroPositivo(String nomeParametro, String msg) {
		double numero = Double.parseDouble(request.getParameter(nomeParametro));
		if(numero < 0){
			erros.put(nomeParametro, msg);
		}
	}

	public boolean temErros() {
		return !erros.isEmpty();
	}

	
	public String get(String chave){
		return erros.get(chave);
	}

	public boolean temErros(String chave) {
		return erros.containsKey(chave);
	}
}
