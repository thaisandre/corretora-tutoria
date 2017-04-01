package br.com.corretora.modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class CDB {

	private final Double valorMinimo = 1000.0;

	private Double valor;
	private LocalDate dataIncial;

	public CDB(Double valor, LocalDate dataInicial) {
		if (valor < valorMinimo) {
			throw new IllegalArgumentException("valor inválido - o valor mínimo para o cdb é " + valorMinimo);
		}
		if (dataInicial.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("data inválida - a data deve ser futura");
		}
		if(valor == null) {
			throw new NullPointerException("o valor não pode ser nulo");
		}
		if(dataInicial == null) {
			throw new NullPointerException("a data não pode ser nula");
		}
		this.valor = valor;
		this.dataIncial = dataInicial;
	}

	public double getValor() {
		return this.valor;
	}

	public Long getIntervalo() {
		return dataIncial.until(LocalDate.now(), ChronoUnit.MONTHS);
	}
	
	public Double getValorMinimo() {
		return valorMinimo;
	}

}
