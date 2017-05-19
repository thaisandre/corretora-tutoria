
public class Login {
	
	private String usuario;
	private String senha;
	
	public Login(String usuario, String senha) {
		valida(usuario);
		valida(senha);
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void valida(String texto) {
		if(texto == null || texto.isEmpty()) {
			throw new IllegalArgumentException(texto + "deve ser preenchido");
		}
	}
	
}
