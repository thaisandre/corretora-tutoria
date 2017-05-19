package br.com.corretora.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "login")
public class LoginUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String login;
	private String senha;

	public LoginUsuario(String login, String senha) {
		valida(login);
		valida(senha);
		
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}
	
	private void valida(String texto) {
		if(texto == null || texto.isEmpty()) {
			throw new IllegalArgumentException(texto + " não deve ser nulo ou vazio");
		}
	}
}
