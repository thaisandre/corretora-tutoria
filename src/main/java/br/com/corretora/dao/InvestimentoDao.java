package br.com.corretora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.corretora.modelo.Investimento;

public class InvestimentoDao {

	private EntityManager manager;
	
	public InvestimentoDao(EntityManager manager) {
		this.manager = manager;
	}

	public void salva(Investimento investimento) {	
		manager.persist(investimento);	
	}

	public List<Investimento> lista() {
		Query query = manager.createQuery("select i from investimento as i", Investimento.class);
		List<Investimento> investimentos = query.getResultList();
		return investimentos;
	}

	public void remove(Investimento investimento) {
		manager.remove(buscaPor(investimento.getId()));
	}

	public Investimento buscaPor(Integer id) {
		return manager.find(Investimento.class, id);
	}

	public void altera(Investimento investimento) {
		manager.merge(investimento);
		
	}
}
