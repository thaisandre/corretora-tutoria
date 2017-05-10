package br.com.corretora.modelo;

public class ImpostoDeRenda implements Desconto {
	
	@Override
	public Double getValor(Aplicacao aplicacao) {
		if(aplicacao.getIntervalo() <= 12) {
			return 0.25;
		} else if(aplicacao.getIntervalo() > 12 && aplicacao.getIntervalo() <= 24) {
			return 0.20;
		} else {
			return 0.15;
		}
	}
}
