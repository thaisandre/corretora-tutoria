package br.com.corretora;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.corretora.dao.AplicacaoDao;
import br.com.corretora.dao.ContaDao;
import br.com.corretora.dao.InvestimentoDao;
import br.com.corretora.dao.UsuarioDao;
import br.com.corretora.modelo.Aplicacao;
import br.com.corretora.modelo.Conta;
import br.com.corretora.modelo.Investimento;
import br.com.corretora.modelo.JPAUtil;
import br.com.corretora.modelo.TipoDeInvestimento;
import br.com.corretora.modelo.Usuario;

public class TestaJPA {
	
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();

		manager.getTransaction().begin();
		UsuarioDao usuarioDao = new UsuarioDao(manager);
		Usuario usuario = new Usuario("renato", "renato@abc.com", "2907");
		usuarioDao.salva(usuario);
		
		ContaDao contaDao = new ContaDao(manager);
		Conta conta = new Conta(usuario, "252-2", 32000.0);
		contaDao.salva(conta);
		
		InvestimentoDao investimentoDao = new InvestimentoDao(manager);
		Investimento investimento = new Investimento(TipoDeInvestimento.CDB, 0.09, 24, 1000.0);
		investimentoDao.salva(investimento);
		
		Investimento investimento2 = new Investimento(TipoDeInvestimento.LCI, 0.13, 24, 1200.0);
		investimentoDao.salva(investimento2);
		
		AplicacaoDao aplicacaoDao = new AplicacaoDao(manager);
		Aplicacao aplicacao = new Aplicacao(conta, investimento, LocalDate.now(), 2500.0);
		aplicacaoDao.salva(aplicacao);
		
		Aplicacao aplicacao2 = new Aplicacao(conta, investimento2, LocalDate.now(), 3000.0);
		aplicacaoDao.salva(aplicacao2);
		
		List<Investimento> lista = aplicacaoDao.getInvestimentosPor(conta);
		System.out.println(lista);
		
		List<Usuario> usuarios = usuarioDao.lista();
		System.out.println(usuarios);
		
		manager.getTransaction().commit();
		manager.close();
		JPAUtil.close();
	}
}
