package br.com.corretora.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.corretora.dao.AplicacaoDao;

public class Corretora {
	
	private AplicacaoDao dao;
	private final List<Investimento> investimentos = new ArrayList<Investimento>();
	
	public Corretora(AplicacaoDao dao) {
		if(dao == null) {
			throw new IllegalArgumentException("parametro não deve ser nulo");
		}
		this.dao = dao;
	}
	
	public List<Investimento> getInvestimentos() {
		return investimentos;
	}
	
	public Aplicacao aplica(Conta conta, Investimento investimento) {
		if((dao.getInvestimentosPor(conta).size() < 5) && (investimentos.contains(investimento))) {
			return conta.investe(investimento);
		}
		else {
			throw new RuntimeException("operação inválida - conta já possui 5 investimentos");
		}
	}
	
	public Investimento criaInvestimento(Double valor, LocalDate dataInicial, Double taxaDeJuros, TipoDeInvestimento tipo) {
		if(dataInicial.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException();
		}
		Investimento investimento = new Investimento(valor, dataInicial, taxaDeJuros, tipo);
		investimentos.add(investimento);
		return investimento;
	}
}
