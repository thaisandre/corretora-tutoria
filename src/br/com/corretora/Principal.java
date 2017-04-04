package br.com.corretora;

import java.time.LocalDate;

import br.com.corretora.modelo.Conta;
import br.com.corretora.modelo.Corretora;
import br.com.corretora.modelo.Investimento;
import br.com.corretora.modelo.TipoDeInvestimento;
import br.com.corretora.modelo.Usuario;

public class Principal {

	public static void main(String[] args) {

		// usuario 1
		Conta conta = new Conta(10000.0);
		Usuario joao = new Usuario("joao", conta);
		LocalDate dataInicial = LocalDate.of(2015, 3, 1);

		Investimento cdb = new Investimento(1000.0, dataInicial, 0.11, TipoDeInvestimento.CDB);
		Investimento lci = new Investimento(1000.0, dataInicial, 0.07, TipoDeInvestimento.LCI);

		// usuario 2
		Conta conta2 = new Conta(20000.0);
		Usuario maria = new Usuario("maria", conta2);
		LocalDate dataInicial2 = LocalDate.of(2014, 3, 1);

		Investimento cdb2 = new Investimento(2000.0, dataInicial2, 0.10, TipoDeInvestimento.CDB);
		Investimento lci2 = new Investimento(1000.0, dataInicial2, 0.05, TipoDeInvestimento.LCI);

		if (joao.investe(cdb)) {
			System.out.println(joao.getNome() + "investiu no cdb");
		} else {
			System.out.println(joao.getNome() + "não conseguiu investir");
		}
		if (joao.investe(lci)) {
			System.out.println(joao.getNome() + "investiu no lci");
		} else {
			System.out.println(joao.getNome() + "não conseguiu investir");
		}

		// lista investimentos joao
		for (Investimento investimento : joao.getInvestimentos()) {
			System.out.println(investimento);
		}
		System.out.println("saldo de " + joao.getNome() + ": " + conta.getSaldo());
		System.out.println("=====");


		if (maria.investe(cdb2)) {
			System.out.println(maria.getNome() + "investiu no cdb");
		} else {
			System.out.println(maria.getNome() + "não conseguiu investir");
		}
		if (maria.investe(lci2)) {
			System.out.println(maria.getNome() + "investiu no lci");
		} else {
			System.out.println(maria.getNome() + "não conseguiu investir");
		}

		// lista investimentos maria
		for (Investimento investimento : maria.getInvestimentos()) {
			System.out.println(investimento);
		}
		System.out.println("saldo de " + maria.getNome() + ": " + conta2.getSaldo());
		System.out.println("=====");

		Corretora corretora = new Corretora();
		corretora.adiciona(joao, joao.getInvestimentos());
		corretora.adiciona(maria, maria.getInvestimentos());
		
		System.out.println("todos os investimentos: ");
		System.out.println(corretora.getListaDeInvestimentos());
		
		System.out.println("=====");
		
		//teste resgate
		joao.resgata(cdb);
		System.out.println("saldo de " + joao.getNome()+  ": " + conta.getSaldo());
		
		System.out.println("=====");
		
		System.out.println("todos os investimentos(atualizado): ");
		System.out.println(corretora.getListaDeInvestimentos());
	}
}
