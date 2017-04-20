package br.com.corretora.modelo;

import br.com.corretora.dao.AplicacaoDao;

public class Aplicacao {

	private Integer id;
	private Conta conta;
	private Investimento investimento;
	private AplicacaoDao dao;

	public Aplicacao(Conta conta, Investimento investimento) {
		if(conta == null) throw new NullPointerException("conta não pode ser nula");
		if(investimento == null) throw new NullPointerException("investimento não pode ser nulo");
		this.conta = conta;
		this.investimento = investimento;
	}

	public Conta getConta() {
		return conta;
	}

	public Investimento getInvestimento() {
		return investimento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean resgata() {
		if(getInvestimento().getIntervalo() >= 24) {
			conta.deposita(investimento.getTotalResgate());
			return true;
		}
		else {
			throw new RuntimeException("operação inválida - não pode resgatar antes de completar 2 anos");
		}
	}

}
