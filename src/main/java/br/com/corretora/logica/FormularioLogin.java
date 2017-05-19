package br.com.corretora.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormularioLogin implements Logica{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getAttribute("mensagens");
		request.getRequestDispatcher("/WEB-INF/paginas/usuario-login.jsp").forward(request, response);
	}
}
