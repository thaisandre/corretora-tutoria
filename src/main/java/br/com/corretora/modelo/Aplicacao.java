package br.com.corretora.modelo;

public class Aplicacao {

	Integer id;
	Conta conta;
	Investimento investimento;

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
		if (investimento.getIntervalo() >= 24) {
			conta.deposita(investimento.getTotalResgate());
			//conta.getInvestimentos().remove(investimento);
			return true;
		}
		throw new RuntimeException("não pode resgatar antes da aplicação completar 2 anos");
	}
}
