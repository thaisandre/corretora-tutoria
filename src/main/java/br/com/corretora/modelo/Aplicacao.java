package br.com.corretora.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="aplicacao")
public class Aplicacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="id_conta")
	private Conta conta;
	
	@OneToOne
	@JoinColumn(name="id_investimento")
	private Investimento investimento;

	public Aplicacao(Conta conta, Investimento investimento) {
		if(conta == null) throw new IllegalArgumentException("conta não pode ser nula");
		if(investimento == null) throw new IllegalArgumentException("investimento não pode ser nulo");
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
