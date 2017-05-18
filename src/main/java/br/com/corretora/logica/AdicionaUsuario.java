package br.com.corretora.logica;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.corretora.dao.UsuarioDao;
import br.com.corretora.modelo.Usuario;
import br.com.corretora.modelo.Validador;

public class AdicionaUsuario implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Validador validador = new Validador(request);
		validador.verificaNulo("nome", "nome é obrigatório");
		validador.verificaNulo("login", "login é obrigatório");
		validador.verificaNulo("senha", "senha é obrigatório");

		if (validador.temErros()) {
			request.setAttribute("erros", validador);
			return "/cadastra-usuario.jsp";
		}

		Usuario usuario = new Usuario(request.getParameter("nome"), request.getParameter("login"),
				request.getParameter("senha"));

		EntityManager manager = (EntityManager) request.getAttribute("manager");
		UsuarioDao usuarioDao = new UsuarioDao(manager);
		usuarioDao.salva(usuario);

		System.out.println("cadastrando usuário... ");
		return "WEB-INF/paginas/usuario-cadastrado.jsp";
	}
}
