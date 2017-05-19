package br.com.corretora.logica;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.corretora.dao.UsuarioDao;
import br.com.corretora.modelo.Usuario;

public class MostraUsuario implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		EntityManager manager = (EntityManager) request.getAttribute("manager");
		UsuarioDao usuarioDao = new UsuarioDao(manager);
		Usuario usuario = usuarioDao.buscaPor(id);
		
		request.setAttribute("usuario", usuario);
		
		System.out.println("mostrando dados do usuário para alteração...");
		
		response.sendRedirect("WEB-INF/paginas/altera-usuario.jsp");
	}

}
