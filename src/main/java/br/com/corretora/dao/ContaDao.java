package br.com.corretora.dao;

import javax.persistence.EntityManager;

import br.com.corretora.modelo.Conta;

public class ContaDao {

	private EntityManager manager;
	
	public ContaDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public void salva(Conta conta) {
		manager.persist(conta);
	}
}
