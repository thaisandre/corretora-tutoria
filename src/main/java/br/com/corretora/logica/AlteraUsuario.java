package br.com.corretora.logica;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.corretora.dao.UsuarioDao;
import br.com.corretora.modelo.Usuario;

public class AlteraUsuario implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario(nome, login, senha);
		usuario.setId(id);
		
		EntityManager manager = (EntityManager) request.getAttribute("manager");
		UsuarioDao usuarioDao = new UsuarioDao(manager);
		usuarioDao.altera(usuario);
		
		System.out.println("alterando usuário... ");
		
		response.sendRedirect("mvc?logica=ListaUsuario");
	}

}
