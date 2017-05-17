package br.com.corretora.logica;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.corretora.dao.UsuarioDao;
import br.com.corretora.modelo.Usuario;
import br.com.corretora.modelo.ValidaTexto;

public class AdicionaUsuario implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			//ValidaTexto.validaTexto(request.getParameter(arg0));
			
			Usuario usuario = new Usuario(request.getParameter("nome").trim(), request.getParameter("login").trim(),
					request.getParameter("senha").trim());

			EntityManager manager = (EntityManager) request.getAttribute("manager");
			UsuarioDao usuarioDao = new UsuarioDao(manager);
			usuarioDao.salva(usuario);

			System.out.println("cadastrando usuário... ");
			return "WEB-INF/paginas/usuario-cadastrado.jsp";
		} catch (IllegalArgumentException e) {
			request.setAttribute("errorMessage", e.getMessage());
			return "/cadastra-usuario.jsp";
		}
	}
}
