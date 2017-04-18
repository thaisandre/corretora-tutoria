package br.com.corretora.modelo;

public class SemDesconto implements Desconto {

	@Override
	public Double getValor(Investimento investimento) {
		return 0.0;
	}

	

}
