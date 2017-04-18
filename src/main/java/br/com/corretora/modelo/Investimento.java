package br.com.corretora.modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Investimento {
	
	private Integer id;
	private Double valor;
	private LocalDate dataInicial;
	private Double taxaDeJuros;
	private TipoDeInvestimento tipo;

	private final Double valorMinimo = 1000.0;

	public Investimento(Double valor, LocalDate dataInicial, Double taxaDeJuros, TipoDeInvestimento tipo) {
		if (valor < valorMinimo)
			throw new IllegalArgumentException("valor inválido - o valor mínimo para o cdb é " + valorMinimo);
		if (valor == null)
			throw new NullPointerException("o valor não pode ser nulo");
		if (valor < 0.0)
			throw new IllegalArgumentException("o valor deve ser positivo");
		// if (dataInicial.isBefore(LocalDate.now()))
		// throw new IllegalArgumentException("data inválida - a data deve ser
		// futura");
		if (dataInicial == null)
			throw new NullPointerException("a data não pode ser nula");
		if (taxaDeJuros == null)
			throw new NullPointerException("a taxa de juros não pode ser nula");
		if (taxaDeJuros < 0.0)
			throw new IllegalArgumentException("a taxa de Juros deve ser positiva");
		if (tipo == null)
			throw new NullPointerException("o tipo não pode ser nulo");

		this.valor = valor;
		this.dataInicial = dataInicial;
		this.taxaDeJuros = taxaDeJuros;
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public TipoDeInvestimento getTipo() {
		return tipo;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public Double getTaxaDeJuros() {
		return taxaDeJuros;
	}
	
	public Long getIntervalo() {
		return dataInicial.until(LocalDate.now(), ChronoUnit.MONTHS);
	}

	private Double getRentabilidadeMensal() {
		return Math.pow(10, Math.log10(1 + (getTaxaDeJuros())) / 12) - 1;
	}

	private Double getRendimentoBruto() {
		return getValor()*(Math.pow(1 + getRentabilidadeMensal(), getIntervalo())  - 1);
	}

	private Double getDesconto() {
		return getTipo().calcula(this)*getRendimentoBruto();
	}

	private Double getRendimentoLiquido() {
		return getRendimentoBruto() - getDesconto();
	}

	public Double getTotalResgate() {
		return getValor() + getRendimentoLiquido();
	}
	
	@Override
	public String toString() {
		return "[" + this.getTipo() + ", " + this.getValor() + ", " + this.getTaxaDeJuros() + ", "
				+ this.getDataInicial().toString() + "]";
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

}
