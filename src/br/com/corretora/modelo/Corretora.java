package br.com.corretora.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Corretora {

	Map<Usuario, List<Investimento>> listaInvestimentos = new HashMap<Usuario, List<Investimento>>();

	public Map<Usuario, List<Investimento>> getListaDeInvestimentos() {
		return this.listaInvestimentos;
	}

	public List<Investimento> adiciona(Usuario usuario, List<Investimento> investimentos) {
		return this.listaInvestimentos.put(usuario, investimentos);
	}

	public List<Investimento> remove(Usuario usuario) {
		return this.listaInvestimentos.remove(usuario);
	}

}
