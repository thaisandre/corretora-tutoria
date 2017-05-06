package br.com.corretora.dao;

import javax.persistence.EntityManager;

import br.com.corretora.modelo.Usuario;

public class UsuarioDao {

	private EntityManager manager;
		
	public UsuarioDao(EntityManager manager) {
		this.manager = manager;
	}

	public void salva(Usuario usuario) {
		manager.persist(usuario);
	}		
}
