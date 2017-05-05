package br.com.corretora.modelo;

import java.util.Arrays;
import java.util.List;

public enum TipoDeInvestimento {
	
	CDB(new ImpostoDeRenda()),
	LCI(new SemDesconto());
	
	private List<Desconto> desconto;
	
	TipoDeInvestimento (Desconto...descontos) {
		desconto = Arrays.asList(descontos); 
	}
	
	public Double calcula(Investimento investimento) {
		return desconto.stream().map(i -> i.getValor(investimento))
				.reduce(0.0, (a,b) -> a+b);
	}
}
