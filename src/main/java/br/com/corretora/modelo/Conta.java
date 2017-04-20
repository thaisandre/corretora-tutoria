package br.com.corretora.modelo;

import java.util.HashSet;
import java.util.Set;

public class Conta {

	private Integer id;
	private String numero;
	private Double saldo;
	private Usuario usuario;
	private static Set<String> numeros = new HashSet<String>();

	public Conta(Usuario usuario, String numero, Double saldo) {
		if (usuario == null)
			throw new NullPointerException("usuario não pode ser nulo");
		if (saldo == null)
			throw new NullPointerException("Saldo não pode ser vazio");
		if (saldo <= 0.0)
			throw new IllegalArgumentException("Saldo deve ser positivo");
		if (numero == null)
			throw new NullPointerException("numero não pode ser nulo");
		if (numeros.contains(numero))
			throw new IllegalArgumentException("numero de conta já existente");
		this.usuario = usuario;
		this.saldo = saldo;
		this.numero = numero;
		cadastra();
	}

	public Conta() {
	}

	public String getNumero() {
		return numero;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	private boolean saca(Double valor) {
		if (valor <= saldo) {
			saldo -= valor;
			return true;
		} else {
			throw new IllegalArgumentException("saque inválido - valor não pode ser maior do que o saldo");
		}
	}

	public boolean deposita(Double valor) {
		if (valor > 0.0) {
			saldo += valor;
			return true;
		} else {
			throw new IllegalArgumentException("depósito inválido - valor não pode ser negativo");
		}
	}

	public Aplicacao investe(Investimento investimento) {
		saca(investimento.getValor());
		Aplicacao aplicacao = new Aplicacao(this, investimento);
		return aplicacao;
	}

	private boolean cadastra() {
		return numeros.add(this.numero);
	}

	@Override
	public String toString() {
		return this.numero;
	}
}
