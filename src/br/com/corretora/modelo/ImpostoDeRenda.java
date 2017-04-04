package br.com.corretora.modelo;

public class ImpostoDeRenda {
	
	public Double getValor(Investimento investimento) {
		if(investimento.getIntervalo() <= 12) {
			return 0.25;
		} else if(investimento.getIntervalo() > 12 && investimento.getIntervalo() <= 24) {
			return 0.20;
		} else {
			return 0.15;
		}
	}
}
