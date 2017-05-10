package br.com.corretora.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements Logica {

	@Override
	public String executa(HttpServletRequest resquest, HttpServletResponse response) throws Exception {
		System.out.println("executando primeira logica");
		
		return "primeira-logica.jsp";
	}
	
	
}
