package br.com.corretora.logica;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.corretora.dao.UsuarioDao;
import br.com.corretora.modelo.Usuario;

public class Login implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//Integer id = Integer.parseInt(request.getParameter("id"));
		
		String login = request.getParameter("nome");
		String senha = request.getParameter("senha");
		
		EntityManager manager = (EntityManager) request.getAttribute("manager");
		UsuarioDao usuarioDao = new UsuarioDao(manager);
		//Usuario usuario = usuarioDao.buscaPor(id);
		
		for(Usuario u : usuarioDao.lista()) {
			if(u.getLogin().equals(login) && u.getSenha().equals(senha)){
				request.getSession().setAttribute("usuario", u);
				response.sendRedirect("/corretora-tutoria/mvc?logica=UsuarioLogado");
			}
		}
		
		request.setAttribute("mensagem", "login inválido!");
		request.getRequestDispatcher("/WEB-INF/paginas/usuario-login.jsp").forward(request, response);
	}

}
