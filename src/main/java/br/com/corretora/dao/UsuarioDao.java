package br.com.corretora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.corretora.modelo.Usuario;

public class UsuarioDao {

	private EntityManager manager;
		
	public UsuarioDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public void salva(Usuario usuario) {
		manager.persist(usuario);
	}
	
	public List<Usuario> lista() {
		Query query = manager.createQuery("select u from usuario as u", Usuario.class);
				   
		List<Usuario> usuarios = query.getResultList();
		return usuarios;
	}

	public void remove(Usuario usuario) {
		manager.remove(buscaPor(usuario.getId()));
	}

	public Usuario buscaPor(Integer id) {
		return manager.find(Usuario.class, id);
	}

	public void altera(Usuario usuario) {
		manager.merge(usuario);
	}
	
	public boolean existe(String nome, String senha) {
		if(manager.find(Usuario.class, nome).equals(manager.find(Usuario.class, senha)))
			return true;
		return false;
	}
}
