package br.com.corretora.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.corretora.logica.Logica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("entrou na servlet");
		
		String action = request.getParameter("logica");
		String className = "br.com.corretora.logica." + action;
		System.out.println(action);
		
		try{
			Class<?> classe = Class.forName(className);
			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executa(request, response);
			
			request.getRequestDispatcher(pagina).forward(request, response);
		} catch (Exception e){
			throw new ServletException("A logica de negócio causou uma exceção" + e);
		}
	}

}
