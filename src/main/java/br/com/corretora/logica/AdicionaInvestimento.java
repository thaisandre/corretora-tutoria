package br.com.corretora.logica;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.corretora.dao.InvestimentoDao;
import br.com.corretora.modelo.Investimento;
import br.com.corretora.modelo.TipoDeInvestimento;
import br.com.corretora.modelo.Validador;

public class AdicionaInvestimento implements Logica {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Validador validador = new Validador(request);
		validador.verificaNulo("tipo", "Tipo é obrigatório");
		validador.verificaNumero("taxaDeJuros", "A taxa precisa ser um número");
		if(!validador.temErros("taxaDeJuros")) {
			validador.verificaNumeroPositivo("taxaDeJuros", "A taxa precisa ser positiva");
		}
		validador.verificaNumero("prazo", "O prazo precisa ser um número");
		if (!validador.temErros("prazo")) {
			validador.verificaNumeroPositivo("prazo", "O prazo precisa ser positivo");
		}
		validador.verificaNumero("valorMinimo", "O valor minimo precisa ser um número");
		if (!validador.temErros("valorMinimo")) {
			validador.verificaNumeroPositivo("valorMinimo", "O valor mínimo precisa ser positivo");
		}

		if (validador.temErros()) {
			request.setAttribute("erros", validador);
			return "/cadastra-investimento.jsp";
		}
		
		TipoDeInvestimento tipo = TipoDeInvestimento.valueOf(request.getParameter("tipo"));
		Double taxaDeJuros = Double.parseDouble(request.getParameter("taxaDeJuros"));
		Integer prazo = Integer.parseInt(request.getParameter("prazo"));
		Double valorMinimo = Double.parseDouble(request.getParameter("valorMinimo"));
		
		Investimento investimento = new Investimento(tipo, taxaDeJuros, prazo, valorMinimo);
		EntityManager manager = (EntityManager) request.getAttribute("manager");
		InvestimentoDao investimentoDao = new InvestimentoDao(manager);
		investimentoDao.salva(investimento);
		
		//response.sendRedirect("/WEB-INF/investimento-cadastrado.jsp");

		return "/WEB-INF/paginas/investimento-cadastrado.jsp";
	}
}
