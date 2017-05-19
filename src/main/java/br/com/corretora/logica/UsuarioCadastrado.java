package br.com.corretora.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioCadastrado implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getRequestDispatcher("WEB-INF/paginas/usuario-cadastrado.jsp").forward(request, response);
	}
	
}
