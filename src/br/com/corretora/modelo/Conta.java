package br.com.corretora.modelo;

import java.util.ArrayList;
import java.util.List;

public class Conta {
	
	private Integer id;
	private Double saldo;
	private List<Investimento> investimentos = new ArrayList<Investimento>();

	public Conta(Double saldo) {
		if (saldo == null) throw new NullPointerException("Saldo não pode ser vazio");
		if (saldo < 0.0) throw new IllegalArgumentException("Saldo não pode ser negativo");
		
		this.saldo = saldo;
	}
	
	public double getSaldo() {
		return this.saldo;
	}

	public Integer getId() {
		return id;
	}
	
	public List<Investimento> getInvestimentos() {
		return investimentos;
	}

	public boolean saca(Double valor) {
		if (valor <= saldo) {
			saldo -= valor;
			return true;
		} else {
			throw new IllegalArgumentException("saque inválido - valor não pode ser maior do que o saldo");
		}
	}

	public void deposita(Double valor) {
		saldo += valor;
	}
	
	@Override
	public String toString() {
		return "saldo: " + this.saldo;
	}
	
}
