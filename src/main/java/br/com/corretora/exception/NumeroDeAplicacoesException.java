package br.com.corretora.exception;

public class NumeroDeAplicacoesException extends Exception {

	private static final long serialVersionUID = 4094070964158340217L;
	
	public NumeroDeAplicacoesException() {
		super("operação inválida - conta já tem 5 aplicações.");
	}
}
