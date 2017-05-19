package br.com.corretora.logica;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.corretora.dao.InvestimentoDao;
import br.com.corretora.modelo.Investimento;
import br.com.corretora.modelo.TipoDeInvestimento;
import br.com.corretora.modelo.Validador;

public class AdicionaInvestimento implements Logica {
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Validador validador = new Validador(request);
		
		validador.verificaNulo("tipo", "Tipo é obrigatório");
		validador.verificaNumero("taxaDeJuros", "A taxa precisa ser um número");
		if(!validador.temErros("taxaDeJuros")) {
			validador.verificaNumeroPositivo("taxaDeJuros", "A taxa precisa ser positiva");
		}
		validador.verificaNumero("prazo", "O prazo precisa ser um número");
		if (!validador.temErros("prazo")) {
			validador.verificaNumeroNaoNegativo("prazo", "O prazo precisa ser maio ou igual a zero");
		}
		validador.verificaNumero("valorMinimo", "O valor minimo precisa ser um número");
		if (!validador.temErros("valorMinimo")) {
			validador.verificaNumeroPositivo("valorMinimo", "O valor mínimo precisa ser positivo");
		}
		if (validador.temErros()) {
			System.out.println("tem erros");
			request.setAttribute("erros", validador);
			request.getRequestDispatcher("/WEB-INF/paginas/cadastra-investimento.jsp").forward(request, response);
		}
		
		TipoDeInvestimento tipo = TipoDeInvestimento.valueOf(request.getParameter("tipo"));
		Double taxaDeJuros = Double.parseDouble(request.getParameter("taxaDeJuros"));
		Integer prazo = Integer.parseInt(request.getParameter("prazo"));
		Double valorMinimo = Double.parseDouble(request.getParameter("valorMinimo"));
		
		Investimento investimento = new Investimento(tipo, taxaDeJuros, prazo, valorMinimo);
		
		EntityManager manager = (EntityManager) request.getAttribute("manager");
		InvestimentoDao investimentoDao = new InvestimentoDao(manager);
		investimentoDao.salva(investimento);
	
		response.sendRedirect("/corretora-tutoria/mvc?logica=InvestimentoCadastrado");
	}
}
