package br.com.corretora.modelo;

public class Conta {

	private Double saldo;

	public Conta(Double saldo) {
		if (saldo == null) throw new NullPointerException("Saldo não pode ser vazio");
		if (saldo < 0.0) throw new IllegalArgumentException("Saldo não pode ser negativo");
		
		this.saldo = saldo;
	}

	public double getSaldo() {
		return this.saldo;
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
}
