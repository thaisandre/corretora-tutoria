package br.com.corretora.logica;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.corretora.dao.InvestimentoDao;
import br.com.corretora.modelo.Investimento;

public class RemoveInvestimento implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		Investimento investimento = new Investimento();
		investimento.setId(id);
		
		EntityManager manager = (EntityManager) request.getAttribute("manager");
		InvestimentoDao investimentoDao = new InvestimentoDao(manager);
		investimentoDao.remove(investimento);
		
		System.out.println("removendo investimento... ");
		
		return "mvc?logica=ListaInvestimento";
	}
	
}
