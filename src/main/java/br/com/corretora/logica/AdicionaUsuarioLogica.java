package br.com.corretora.logica;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.corretora.dao.UsuarioDao;
import br.com.corretora.modelo.Usuario;

public class AdicionaUsuarioLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Usuario usuario = new Usuario(request.getParameter("nome"), request.getParameter("login"),
				request.getParameter("senha"));
		
		EntityManager manager = (EntityManager) request.getAttribute("manager");
		UsuarioDao usuarioDao = new UsuarioDao(manager);
		usuarioDao.salva(usuario);

		return "WEB-INF/paginas/usuario-cadastrado.jsp";
	}
}
