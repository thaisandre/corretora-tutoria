package br.com.corretora;

import java.sql.SQLException;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.corretora.dao.AplicacaoDao;
import br.com.corretora.dao.ContaDao;
import br.com.corretora.dao.InvestimentoDao;
import br.com.corretora.dao.UsuarioDao;
import br.com.corretora.modelo.Aplicacao;
import br.com.corretora.modelo.Conta;
import br.com.corretora.modelo.Investimento;
import br.com.corretora.modelo.TipoDeInvestimento;
import br.com.corretora.modelo.Usuario;

public class Principal {

	public static void main(String... args) throws SQLException {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("corretora");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
				
		ContaDao contaDao = new ContaDao(manager);
		UsuarioDao usuarioDao = new UsuarioDao(manager);
		
		AplicacaoDao aplicacaoDao = new AplicacaoDao(manager);
		InvestimentoDao investimentoDao = new InvestimentoDao(manager);
				
		// usuario 1 com 2 contas
		Usuario joao = new Usuario("joao", "joao@abc.com", "4521");
		usuarioDao.salva(joao);
		
		Conta conta = new Conta(joao, "871-8", 10000.0);
		contaDao.salva(conta);
		
		Conta conta2 = new Conta(joao, "456-3", 20000.0);
		contaDao.salva(conta2);
		
		LocalDate dataInicial = LocalDate.of(2015, 3, 22);

		Investimento cdb = new Investimento(1000.0, dataInicial, 0.10, TipoDeInvestimento.CDB);
		investimentoDao.salva(cdb);
		Investimento lci = new Investimento(1000.0, dataInicial, 0.10, TipoDeInvestimento.LCI);
		investimentoDao.salva(lci);

		// usuario 2 com 1 conta
		Usuario maria = new Usuario("maria", "maria@abc.com", "7178");
		usuarioDao.salva(maria);
		Conta conta3 = new Conta(maria, "226-1", 19600.0);
		contaDao.salva(conta3);
		
		LocalDate dataInicial2 = LocalDate.of(2014, 4, 12);

		Investimento cdb2 = new Investimento(2400.0, dataInicial2, 0.12, TipoDeInvestimento.CDB);
		investimentoDao.salva(cdb2);
		Investimento lci2 = new Investimento(1000.0, dataInicial2, 0.07, TipoDeInvestimento.LCI);
		investimentoDao.salva(lci2);
		
		Aplicacao aplicacao = conta.investe(cdb2);
		aplicacaoDao.salva(aplicacao);
		Aplicacao aplicacao1 = conta2.investe(lci);
		aplicacaoDao.salva(aplicacao1);
		
		Aplicacao aplicacao2 = conta3.investe(cdb);
		aplicacaoDao.salva(aplicacao2);
		Aplicacao aplicacao3 = conta3.investe(lci2);
		aplicacaoDao.salva(aplicacao3);
		
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
}
