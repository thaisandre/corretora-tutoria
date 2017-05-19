package br.com.corretora.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormularioInvestimento implements Logica{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("entrou formulario");
		request.getAttribute("erros");
		request.getRequestDispatcher("WEB-INF/paginas/cadastra-investimento.jsp").forward(request, response);
	}

}
