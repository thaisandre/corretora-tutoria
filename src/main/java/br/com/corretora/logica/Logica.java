package br.com.corretora.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception; 
}
