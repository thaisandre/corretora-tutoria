package br.com.corretora.modelo;

public class TaxaDeAdministracao implements Desconto {

	@Override
	public Double getValor(Aplicacao aplicacao) {
		return 0.01;
	}

}
