package br.com.corretora.logica;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.corretora.dao.InvestimentoDao;
import br.com.corretora.modelo.Investimento;
import br.com.corretora.modelo.TipoDeInvestimento;

public class AlteraInvestimento implements Logica {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		TipoDeInvestimento tipo = TipoDeInvestimento.valueOf(request.getParameter("tipo"));
		Double taxaDeJuros = Double.parseDouble(request.getParameter("taxaDeJuros"));
		Integer prazo = Integer.parseInt(request.getParameter("prazo"));
		Double valorMinimo = Double.parseDouble(request.getParameter("valorMinimo"));
		
		Investimento investimento = new Investimento(tipo, taxaDeJuros, prazo, valorMinimo);
		investimento.setId(id);
		
		EntityManager manager = (EntityManager) request.getAttribute("manager");
		InvestimentoDao investimentoDao = new InvestimentoDao(manager);
		investimentoDao.altera(investimento);
		
		System.out.println("alterando investimento... ");
		
		response.sendRedirect("mvc?logica=ListaInvestimento");
	}
	
	
}
