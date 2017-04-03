package br.com.corretora.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private Conta conta;
	private List<Investimento> investimentos = new ArrayList<Investimento>();

	public Usuario(Conta conta) {
		if(conta == null) {
			throw new NullPointerException("conta não pode ser nula");
		}
		this.conta = conta;
	}

	public boolean resgata(Investimento investimento) {
		if(investimento.getIntervalo() < 24) return false;
		return true;
	}

	public List<Investimento> getInvestimentos() {
		return investimentos ;
	}

	public boolean investe(Investimento investimento) {
		conta.saca(investimento.getValor());
		investimentos.add(investimento);
		return true;
	}

}
