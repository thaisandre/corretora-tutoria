package br.com.corretora.modelo;

public class Usuario {

	private Integer id;
	private String nome;
	private Conta conta;

	public Usuario(String nome, Conta conta) {
		if (nome == null) {
			throw new NullPointerException("nome não pode ser nulo");
		}
		this.conta = conta;
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public Conta getConta() {
		return this.conta;
	}

	public boolean investe(Investimento investimento) {
		conta.saca(investimento.getValor());
		conta.getInvestimentos().add(investimento);
		return true;
	}

	public boolean resgata(Investimento investimento) {
		if (investimento.getIntervalo() > 24) {
			conta.deposita(investimento.getTotalResgate());
			System.out.println("valor do resgate de " + this.nome + ": " + investimento.getTotalResgate());
			conta.getInvestimentos().remove(investimento);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return this.nome;
	}
}
