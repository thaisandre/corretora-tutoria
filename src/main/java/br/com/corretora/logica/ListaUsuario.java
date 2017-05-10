package br.com.corretora.logica;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.corretora.dao.UsuarioDao;
import br.com.corretora.modelo.Usuario;

public class ListaUsuario implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		EntityManager manager = (EntityManager) request.getAttribute("manager");
		UsuarioDao usuarioDao = new UsuarioDao(manager);
		List<Usuario> usuarios = usuarioDao.lista();
		
		request.setAttribute("usuarios", usuarios);
		
		return "/WEB-INF/paginas/lista-usuarios.jsp";
	}

}
