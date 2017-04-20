package br.com.corretora.modelo;

import br.com.corretora.dao.AplicacaoDao;

public class Corretora {
	
	private AplicacaoDao dao;
	
	public Corretora(AplicacaoDao dao) {
		this.dao = dao;
	}
	
	public Aplicacao aplica(Conta conta, Investimento investimento) {
		if(dao.getInvestimentosPor(conta).size() < 5) {
			return conta.investe(investimento);
		}
		else {
			throw new RuntimeException("operação inválida - conta já possui 5 investimentos");
		}
	}
}
