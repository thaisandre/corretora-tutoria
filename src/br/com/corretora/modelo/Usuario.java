package br.com.corretora.modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private String nome;
	private Conta conta;
	private List<Investimento> investimentos = new ArrayList<Investimento>();

	public Usuario(String nome, Conta conta) {
		if (conta == null) {
			throw new NullPointerException("conta não pode ser nula");
		}
		if(nome == null) {
			throw new NullPointerException("nome não pode ser nulo");
		}
		
		this.nome = nome;
		this.conta = conta;
	}
	
	public String getNome() {
		return this.nome;
	}

	public List<Investimento> getInvestimentos() {
		return investimentos;
	}

	public boolean investe(Investimento investimento) {
		conta.saca(investimento.getValor());
		investimentos.add(investimento);
		return true;
	}

	public boolean resgata(Investimento investimento) {
		if (investimento.getIntervalo() > 24) {
			conta.deposita(investimento.getTotalResgate());
			System.out.println("valor do resgate de " + this.nome + ": " + investimento.getTotalResgate());
			investimentos.remove(investimento);
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
}
