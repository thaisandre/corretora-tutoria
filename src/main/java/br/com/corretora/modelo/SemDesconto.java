package br.com.corretora.modelo;

public class SemDesconto implements Desconto {

	@Override
	public Double getValor(Aplicacao aplicacao) {
		return 0.0;
	}
}
