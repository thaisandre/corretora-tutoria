package br.com.corretora.logica;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.corretora.dao.InvestimentoDao;
import br.com.corretora.modelo.Investimento;

public class MostraInvestimento implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Integer id = Integer.parseInt(request.getParameter("id"));
		
		EntityManager manager = (EntityManager) request.getAttribute("manager");
		InvestimentoDao investimentoDao = new InvestimentoDao(manager );
		Investimento investimento = investimentoDao.buscaPor(id);
		
		request.setAttribute("investimento", investimento);
		
		System.out.println("mostando dados do investimento para alteração...");
		
		response.sendRedirect("WEB-INF/paginas/altera-investimento.jsp");
	}

}
