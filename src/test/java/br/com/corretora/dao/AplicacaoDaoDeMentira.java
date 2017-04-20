package br.com.corretora.dao;

import java.util.List;

import br.com.corretora.modelo.Conta;
import br.com.corretora.modelo.Investimento;

public class AplicacaoDaoDeMentira extends AplicacaoDao {

	private List<Investimento> investimentos;
	
	public AplicacaoDaoDeMentira(List<Investimento> investimentos) {
		super(null);
		this.investimentos = investimentos;
	}
	
	@Override
	public List<Investimento> getInvestimentosPor(Conta conta) {
		return investimentos;
	}
}
