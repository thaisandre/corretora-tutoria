package br.com.corretora.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String login;
	private String senha;
	
	public Usuario(String nome, String login, String senha) {
			valida(nome);
			valida(login);
			valida(senha);
			this.nome = nome;
			this.login = login;
			this.senha = senha;
	}
	private void valida(String parametro) {
		if(parametro == null || parametro.isEmpty()) {
			throw new IllegalArgumentException("campo " + parametro + " deve ser preenchido");
		}
	}
	
	public Usuario() {}
	
	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return this.nome;
	}
}
