package br.com.corretora.modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "aplicacao")
public class Aplicacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "id_conta")
	private Conta conta;

	@OneToOne
	@JoinColumn(name = "id_investimento")
	private Investimento investimento;

	private LocalDate dataInicial;
	private Double valor;

	public Aplicacao(Conta conta, Investimento investimento, LocalDate dataInicial, Double valor) {
		if (conta == null)
			throw new IllegalArgumentException("conta não pode ser nula");
		if (investimento == null)
			throw new IllegalArgumentException("investimento não pode ser nulo");
		if(dataInicial == null)
			throw new IllegalArgumentException("data não pode ser nula");
		if(valor == null)
			throw new IllegalArgumentException("valor não pode ser nulo");
		if(valor <= investimento.getValorMinimo())
			throw new IllegalArgumentException("valor mínimo deve ser " + investimento.getValorMinimo());
		this.conta = conta;
		this.investimento = investimento;
		this.dataInicial = dataInicial;
		this.valor = valor;
	}
	
	public Aplicacao(){}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Conta getConta() {
		return conta;
	}

	public Investimento getInvestimento() {
		return investimento;
	}


	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public Double getValor() {
		return valor;
	}
	
	public Long getIntervalo() {
		return getDataInicial().until(LocalDate.now(), ChronoUnit.MONTHS);
	}
	
	private Double getRendimentoBruto() {
		return getValor() * (Math.pow(1 + investimento.getRentabilidadeMensal(), getIntervalo()) - 1);
	}
	
	private Double getDesconto() {
		return investimento.getTipo().calcula(this) * getRendimentoBruto();
	}

	private Double getRendimentoLiquido() {
		return getRendimentoBruto() - getDesconto();
	}

	private Double getTotalResgate() {
		return getValor() + getRendimentoLiquido();
	}

	public boolean resgata() {
		if (getIntervalo() >= investimento.getPrazo()) {
			conta.deposita(getTotalResgate());
			return true;
		} else {
			throw new RuntimeException("operação inválida - não pode resgatar antes de completar 2 anos");
		}
	}
}
