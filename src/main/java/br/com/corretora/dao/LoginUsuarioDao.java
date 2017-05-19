package br.com.corretora.dao;

import javax.persistence.EntityManager;

import br.com.corretora.modelo.LoginUsuario;

public class LoginUsuarioDao {
	
private EntityManager manager;
	
	public LoginUsuarioDao(EntityManager manager) {
		this.manager = manager;
	}

	public void salva(LoginUsuario login) {	
		manager.persist(login);	
	}
	public LoginUsuario buscaPor(Integer id) {
		return manager.find(LoginUsuario.class, id);
	}

}
