package br.com.corretora.modelo;

public class Conta {

	private Double saldo;

	public Conta(Double saldo) {
		if(saldo == null) {
			throw new NullPointerException("Saldo não poser vazio");
		}
		if(saldo < 0.0) {
			throw new IllegalArgumentException("Saldo não pode ser negativo");
		}
		this.saldo = saldo;
	}

	public double getSaldo() {
		return this.saldo;
	}

}
