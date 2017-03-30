package br.com.corretora;

import java.time.LocalDate;

import br.com.corretora.modelo.CDB;
import br.com.corretora.modelo.Conta;
import br.com.corretora.modelo.Usuario;

public class Principal {

	public static void main(String[] args) {
		
		
		Conta conta = new Conta(1000.0);
		Usuario thais = new Usuario(conta);
		LocalDate dataInicial = LocalDate.of(2017, 6, 10);
		
		CDB cdb = new CDB(1000.0, dataInicial);
		
		if(thais.investe(cdb)) {
			System.out.println("investiu");
		} else {
			System.out.println("não foi possível concluir o investimento");
		}
		
		if(thais.investe(cdb)) {
			System.out.println("investiu");
		} else {
			System.out.println("operação inválida");
		}
	}
}
