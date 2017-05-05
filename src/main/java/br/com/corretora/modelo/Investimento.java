package br.com.corretora.modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="investimento")
public class Investimento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Double valor;	
	private LocalDate dataInicial;	
	private Double taxaDeJuros;
	
	@Enumerated(EnumType.STRING)
	private TipoDeInvestimento tipo;
	
	private transient final Double valorMinimo = 1000.0;

	public Investimento(Double valor, LocalDate dataInicial, Double taxaDeJuros, TipoDeInvestimento tipo) {
		if (valor == null)
			throw new IllegalArgumentException("o valor não pode ser nulo");
		if (valor < valorMinimo)
			throw new IllegalArgumentException("valor inválido - o valor mínimo para o cdb é " + valorMinimo);
		if (valor < 0.0)
			throw new IllegalArgumentException("o valor deve ser positivo");
		//if (dataInicial.isBefore(LocalDate.now()))
		//	throw new IllegalArgumentException("data inválida - a data deve ser futura");
		if (dataInicial == null)
			throw new IllegalArgumentException("a data não pode ser nula");
		if (taxaDeJuros == null)
			throw new IllegalArgumentException("a taxa de juros não pode ser nula");
		if (taxaDeJuros < 0.0)
			throw new IllegalArgumentException("a taxa de Juros deve ser positiva");
		if (tipo == null)
			throw new IllegalArgumentException("o tipo não pode ser nulo");

		this.valor = valor;
		this.dataInicial = dataInicial;
		this.taxaDeJuros = taxaDeJuros;
		this.tipo = tipo;
	}
	public Investimento() {}
	
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
		return getDataInicial().until(LocalDate.now(), ChronoUnit.MONTHS);
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
