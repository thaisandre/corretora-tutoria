package br.com.corretora.logica;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.corretora.dao.InvestimentoDao;
import br.com.corretora.modelo.Investimento;
import br.com.corretora.modelo.TipoDeInvestimento;

public class AdicionaInvestimentoLogica implements Logica {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TipoDeInvestimento tipo = TipoDeInvestimento.valueOf(request.getParameter("tipo"));
		Double taxaDeJuros = Double.parseDouble(request.getParameter("taxaDeJuros"));
		Integer prazo = Integer.parseInt(request.getParameter("prazo"));
		Double valorMinimo = Double.parseDouble(request.getParameter("valorMinimo"));
		
		Investimento investimento = new Investimento(tipo, taxaDeJuros, prazo, valorMinimo);
		
		EntityManager manager = (EntityManager) request.getAttribute("manager");
		InvestimentoDao investimentoDao = new InvestimentoDao(manager);
		investimentoDao.salva(investimento);

		return "/WEB-INF/paginas/investimento-cadastrado.jsp";
	}

}
