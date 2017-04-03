package br.com.corretora;

import java.time.LocalDate;

import br.com.corretora.modelo.Conta;
import br.com.corretora.modelo.Investimento;
import br.com.corretora.modelo.TipoDeInvestimento;
import br.com.corretora.modelo.Usuario;

public class Principal {

	public static void main(String[] args) {
			
		Conta conta = new Conta(10000.0);
		Usuario thais = new Usuario(conta);
		LocalDate dataInicial = LocalDate.of(2017, 6, 10);
		
		
		Investimento cdb = new Investimento(1000.0, dataInicial, 0.11, TipoDeInvestimento.CDB);
		Investimento lci = new Investimento(1000.0, dataInicial, 0.07, TipoDeInvestimento.LCI);
		
		
		//tenta investir
		if(thais.investe(cdb)) {
			System.out.println("investiu no cdb");
		} else {
			System.out.println("não foi possível concluir o investimento");
		}
		
		if(thais.investe(lci)) {
			System.out.println("investiu no lci");
		} else {
			System.out.println("não foi possível concluir o investimento");
		}
		
		//listar imnvestimentos do usuario
		for(Investimento investimento : thais.getInvestimentos()) {
			System.out.println(investimento);
		}
		
		if(thais.resgata(cdb)) {
			System.out.println("investiu");
		} else {
			System.out.println("operação inválida");
		}		
	}
}
