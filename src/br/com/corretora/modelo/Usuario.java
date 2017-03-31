package br.com.corretora.modelo;

public class Usuario {

	private Conta conta;

	public Usuario(Conta conta) {
		if(conta == null) {
			throw new NullPointerException("conta não pode ser nula");
		}
		this.conta = conta;
	}

	public boolean investe(CDB cdb) {
		if(conta.getSaldo() < cdb.getValor()) {
			return false;
		}
		return true;
	}

	public boolean resgata(CDB cdb) {
		if(cdb.getIntervalo() < 24) {
			return false;
		}
		return true;
	}

}
