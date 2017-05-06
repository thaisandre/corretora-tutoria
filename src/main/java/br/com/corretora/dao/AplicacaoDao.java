package br.com.corretora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.corretora.modelo.Aplicacao;
import br.com.corretora.modelo.Conta;
import br.com.corretora.modelo.Investimento;

public class AplicacaoDao {

	private EntityManager manager;

	public AplicacaoDao(EntityManager manager) {
		this.manager = manager;
	}

	public void salva(Aplicacao aplicacao) {
		manager.persist(aplicacao);
	}
	
	public List<Investimento> getInvestimentosPor(Conta conta) {
		Query query = manager.createQuery("select a.investimento from aplicacao a "+
		          "where a.conta.id like :idDaConta").setParameter("idDaConta", conta.getId());
				   
		List<Investimento> investimentos = query.getResultList();
		return investimentos;
	}
}
