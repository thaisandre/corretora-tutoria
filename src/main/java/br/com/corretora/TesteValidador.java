package br.com.corretora;

import br.com.corretora.modelo.Investimento;
import br.com.corretora.modelo.TipoDeInvestimento;
import br.com.corretora.modelo.Validador;

public class TesteValidador {
	
	public static void main(String[] args) {
		
		Investimento investimento = new Investimento(TipoDeInvestimento.CDB, 0.11, 10, 1000.0);
		Validador.valida(investimento);
	}
}
