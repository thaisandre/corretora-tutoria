package br.com.corretora.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormularioUsuario implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("entrou no FormularioUsuario");
		request.getAttribute("erros");
		request.getRequestDispatcher("WEB-INF/paginas/cadastra-usuario.jsp").forward(request, response);
	}

}
