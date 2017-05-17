package br.com.corretora.logica;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.corretora.dao.InvestimentoDao;
import br.com.corretora.modelo.ErroValidacao;
import br.com.corretora.modelo.Investimento;
import br.com.corretora.modelo.TipoDeInvestimento;
import br.com.corretora.modelo.ValidaInvestimento;
import br.com.corretora.modelo.ValidaTexto;

public class AdicionaInvestimento implements Logica {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ValidaTexto validaTexto = new ValidaTexto();
		Set<ErroValidacao> erros = new HashSet<>();

		TipoDeInvestimento tipo = null;
		Double taxaDeJuros = null;
		Integer prazo = null;
		Double valorMinimo = null;

		for (String parametro : request.getParameterMap().keySet()) {
			ErroValidacao erro = validaTexto.valida(request.getParameter(parametro), parametro);
			System.out.println(parametro);
			if (!(erro.getMensagem() == null))
			//	System.out.println(erro.getMensagem());
				erros.add(erro);
		}

		try {
			tipo = TipoDeInvestimento.valueOf(request.getParameter("tipo"));
			taxaDeJuros = Double.parseDouble(request.getParameter("taxaDeJuros"));
			prazo = Integer.parseInt(request.getParameter("prazo"));
			valorMinimo = Double.parseDouble(request.getParameter("valorMinimo"));
		} catch (NumberFormatException e) {
			//System.out.println("erro de conversão");
			//System.out.println(erros);
			request.setAttribute("erros", erros);
			return "cadastra-investimento.jsp";
		}
		
		ValidaInvestimento valida = new ValidaInvestimento();

		Set<ErroValidacao> erros1 = valida.valida(tipo, taxaDeJuros, prazo, valorMinimo);
		for(ErroValidacao erro : erros1) {
			if(!erros1.isEmpty()) erros.add(erro);
		}
		Investimento investimento = null;
		
		try {
			investimento =  new Investimento(tipo, taxaDeJuros, prazo, valorMinimo);
		} catch (IllegalArgumentException e) {
			System.out.println("erro ao criar o investimento");
			request.setAttribute("erros", valida.getErros());
			return "cadastra-investimento.jsp";
		}

		if (erros.isEmpty()) {
			EntityManager manager = (EntityManager) request.getAttribute("manager");
			InvestimentoDao investimentoDao = new InvestimentoDao(manager);
			investimentoDao.salva(investimento);
		} else {
			System.out.println(valida.getErros());
			request.setAttribute("erros", valida.getErros());
			return "cadastra-investimento.jsp";
		}

		System.out.println("cadastrando investimento... ");

		return "/WEB-INF/paginas/investimento-cadastrado.jsp";
	}
}
