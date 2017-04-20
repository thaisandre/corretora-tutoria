package br.com.corretora.modelo;

import org.junit.Test;

public class UsuarioTest {
	
	@Test(expected = NullPointerException.class)
	public void usuarioNaoPodeTerNomeNulo() {
		new Usuario (null, "joao@abc.com", "123-5");
	}
	
	@Test(expected = NullPointerException.class)
	public void usuarioNaoPodeTerLoginNulo() {
		new Usuario ("joao", null, "123-5");
	}
	
	@Test(expected = NullPointerException.class)
	public void usuarioNaoPodeTerSenhaNula() {
		new Usuario ("joao", "joao@abc.com", null);
	}
	
	@Test(expected = NullPointerException.class)
	public void usuarioNaoPodeTerNomeELoginNulos() {
		new Usuario (null, null, "123-5");
	}
	
	@Test(expected = NullPointerException.class)
	public void usuarioNaoPodeTerNomeESenhaNulos() {
		new Usuario (null, "joao@abc.com", null);
	}
	
	@Test(expected = NullPointerException.class)
	public void usuarioNaoPodeTerLoginESenhaNulos() {
		new Usuario ("joao", null, null);
	}
	
	@Test(expected = NullPointerException.class)
	public void usuarioNaoPodeTerNomeELoginESenhaNulos() {
		new Usuario (null, null, null);
	}
}
