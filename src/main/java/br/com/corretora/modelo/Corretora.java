package br.com.corretora.modelo;

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
	
	public Aplicacao aplica(Conta conta, Investimento investimento, Double valor) {
		if((dao.getInvestimentosPor(conta).size() < 5)) {
			return conta.investe(investimento, valor);
		}
		else {
			throw new RuntimeException("operação inválida - conta já possui 5 investimentos");
		}
	}
}
