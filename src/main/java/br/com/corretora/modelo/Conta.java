package br.com.corretora.modelo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="conta")
public class Conta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String numero;
	
	@Column
	private Double saldo;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	private static Set<String> numeros = new HashSet<String>();

	public Conta(Usuario usuario, String numero, Double saldo) {
		if (usuario == null)
			throw new IllegalArgumentException("usuario não pode ser nulo");
		if (saldo == null)
			throw new IllegalArgumentException("Saldo não pode ser vazio");
		if (saldo <= 0.0)
			throw new IllegalArgumentException("Saldo deve ser positivo");
		if (numero == null)
			throw new IllegalArgumentException("numero não pode ser nulo");
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

	public Aplicacao investe(Investimento investimento, Double valor) {
		saca(valor);
		Aplicacao aplicacao = new Aplicacao(this, investimento, LocalDate.now(), valor);
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
