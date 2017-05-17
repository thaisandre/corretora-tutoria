package br.com.corretora.modelo;

public class ErroValidacao {
	
	private String mensagem;
	private String campo;
	private String valor;

	public ErroValidacao(String mensagem, String campo, String valor) {
		this.mensagem = mensagem;
		this.campo = campo;
		this.valor = valor;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public String getCampo() {
		return campo;
	}
	
	public String getValor() {
		return valor;
	}
	
	@Override
	public String toString() {
		return "["+ mensagem +", " + campo.toString() + ", " + valor.toString() + "]";
	}
}
