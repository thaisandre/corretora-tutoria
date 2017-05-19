package br.com.corretora.logica;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.corretora.dao.InvestimentoDao;
import br.com.corretora.modelo.Investimento;

public class ListaInvestimento implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		EntityManager manager = (EntityManager) request.getAttribute("manager");
		InvestimentoDao investimentoDao = new InvestimentoDao(manager);
		List<Investimento> investimentos = investimentoDao.lista();
		
		request.setAttribute("investimentos", investimentos);
		
		System.out.println("listando investimentos... ");
		request.getRequestDispatcher("WEB-INF/paginas/lista-investimentos.jsp").forward(request, response);
	}
}
