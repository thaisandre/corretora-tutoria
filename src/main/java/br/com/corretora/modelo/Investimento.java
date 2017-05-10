package br.com.corretora.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "investimento")
public class Investimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private TipoDeInvestimento tipo;

	private Double taxaDeJuros;
	private Integer prazo;
	private Double valorMinimo;

	public Investimento(TipoDeInvestimento tipo, Double taxaDeJuros, Integer prazo, Double valorMinimo) {
		if (tipo == null)
			throw new IllegalArgumentException("o tipo não pode ser nulo");
		if (taxaDeJuros == null)
			throw new IllegalArgumentException("a taxa de juros não pode ser nula");
		if (taxaDeJuros < 0.0)
			throw new IllegalArgumentException("a taxa de Juros deve ser positiva");
		if (prazo == null)
			throw new IllegalArgumentException("o prazo nao pode ser nulo");
		if (prazo < 0)
			throw new IllegalArgumentException("prazo não pode ser negativo");
		if(valorMinimo == null) {
			throw new IllegalArgumentException("valor mínimo não pode ser nulo");
		}
		if(valorMinimo < 0.0)
			throw new IllegalArgumentException("valor mínimo não pode ser negativo");
		this.tipo = tipo;
		this.taxaDeJuros = taxaDeJuros;
		this.prazo = prazo;
		this.valorMinimo = valorMinimo;
	}

	public Investimento() {
	}

	public TipoDeInvestimento getTipo() {
		return tipo;
	}

	public Integer getPrazo() {
		return prazo;
	}

	public Double getTaxaDeJuros() {
		return taxaDeJuros;
	}
	
	public Double getValorMinimo() {
		return valorMinimo;
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getRentabilidadeMensal() {
		return Math.pow(10, Math.log10(1 + (getTaxaDeJuros())) / 12) - 1;
	}

	@Override
	public String toString() {
		return "[" + this.getTipo() + ", " + this.getTaxaDeJuros() + ", " + this.getPrazo() + "]";
	}
}
