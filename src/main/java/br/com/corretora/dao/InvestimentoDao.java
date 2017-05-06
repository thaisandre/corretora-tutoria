package br.com.corretora.dao;

import javax.persistence.EntityManager;

import br.com.corretora.modelo.Investimento;

public class InvestimentoDao {

	private EntityManager manager;
	
	public InvestimentoDao(EntityManager manager) {
		this.manager = manager;
	}

	public void salva(Investimento investimento) {	
		manager.persist(investimento);	
	}
}
