package br.com.corretora.logica;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.corretora.dao.UsuarioDao;
import br.com.corretora.modelo.Usuario;

public class RemoveUsuario implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		Usuario usuario = new Usuario();
		usuario.setId(id);
		
		EntityManager manager = (EntityManager) request.getAttribute("manager");
		UsuarioDao usuarioDao = new UsuarioDao(manager);
		usuarioDao.remove(usuario);
		
		System.out.println("removendo usuario... ");
		
		return "mvc?logica=ListaUsuario";
	}
}
