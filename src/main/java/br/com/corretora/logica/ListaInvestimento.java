package br.com.corretora.logica;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.corretora.dao.InvestimentoDao;
import br.com.corretora.modelo.Investimento;

public class ListaInvestimento implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		EntityManager manager = (EntityManager) request.getAttribute("manager");
		InvestimentoDao investimentoDao = new InvestimentoDao(manager);
		List<Investimento> investimentos = investimentoDao.lista();
		
		request.setAttribute("investimentos", investimentos);
		return "WEB-INF/paginas/lista-investimentos.jsp";
	}
}
