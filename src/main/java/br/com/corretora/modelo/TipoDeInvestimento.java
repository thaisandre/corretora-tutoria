package br.com.corretora.modelo;

import java.util.Arrays;
import java.util.List;

public enum TipoDeInvestimento {
	
	CDB(new ImpostoDeRenda()),
	LCI(new SemDesconto()),
	FDI(new ImpostoDeRenda(), new TaxaDeAdministracao());
	
	private List<Desconto> desconto;
	
	TipoDeInvestimento (Desconto...descontos) {
		desconto = Arrays.asList(descontos); 
	}
	
	public Double calcula(Aplicacao aplicacao) {
		return desconto.stream().map(d -> d.getValor(aplicacao))
				.reduce(0.0, (a,b) -> a+b);
	}
}
