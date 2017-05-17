package br.com.corretora.modelo;

import java.util.HashSet;
import java.util.Set;

public class ValidaInvestimento {

	private Set<ErroValidacao> erros = new HashSet<ErroValidacao>();
	
	public Set<ErroValidacao> getErros() {
		return erros;
	}

	public Set<ErroValidacao> valida(TipoDeInvestimento tipo, Double taxaDeJuros, Integer prazo, Double valorMinimo) {
		try {
			validaTipo(tipo);
		} catch (IllegalArgumentException e) {
			erros.add(new ErroValidacao(e.getMessage(), "tipo", tipo.toString()));
		}
		try {
			validaTaxa(taxaDeJuros);
		} catch (IllegalArgumentException e) {
			erros.add(new ErroValidacao(e.getMessage(), "taxaDeJuros", taxaDeJuros.toString()));
		}
		try {
			validaPrazo(prazo);
		} catch (IllegalArgumentException e) {
			erros.add(new ErroValidacao(e.getMessage(), "prazo", prazo.toString()));
		}
		try {
			validaValorMinimo(valorMinimo);
		} catch (IllegalArgumentException e) {
			erros.add(new ErroValidacao(e.getMessage(), "valorMinimo", valorMinimo.toString()));
		}
		return erros;
	}

	private static boolean validaTaxa(Double taxa) {
		if (taxa == null) {
			throw new IllegalArgumentException("taxa deve ser preenchida");
		}
		if (taxa <= 0.0) {
			throw new IllegalArgumentException("taxa deve ter valor positivo");
		}
		return true;
	}

	private static boolean validaTipo(TipoDeInvestimento tipo) {
		if (tipo == null) {
			throw new IllegalArgumentException("tipo deve ser preenchido");
		}
		return true;
	}

	private static boolean validaPrazo(Integer prazo) {
		if (prazo == null) {
			throw new IllegalArgumentException("prazo deve ser preenchido");
		}
		if (prazo < 0) {
			throw new IllegalArgumentException("prazo não deve ser negativo");
		}
		return true;
	}

	private static boolean validaValorMinimo(Double valorMinimo) {
		if (valorMinimo == null) {
			throw new IllegalArgumentException("valor mínimo deve ser preenchido");
		}
		if (valorMinimo < 0.0) {
			throw new IllegalArgumentException("valor mínimo não deve ser negativo");
		}
		return true;
	}
	
	public ErroValidacao valida1(String campo, Object valor) {
		String mensagem = null;
		if(campo == "tipo") {
			try{
			validaTipo((TipoDeInvestimento) valor);
			} catch (IllegalArgumentException e) {
				return new ErroValidacao(e.getMessage(), campo, valor.toString());
			}
		}
		if(campo == "taxa") {
			try{
			validaTaxa((Double) valor);
			} catch (IllegalArgumentException e) {
				return new ErroValidacao(e.getMessage(), campo, valor.toString());
			}
		}
		if(campo == "prazo") {
			try {
			validaPrazo((Integer) valor);
			} catch (IllegalArgumentException e) {
				return new ErroValidacao(e.getMessage(), campo, valor.toString());
			}
		}
		if(campo == "valor mńimo") {
			try {
				validaValorMinimo((Double) valor);
			} catch (IllegalArgumentException e) {
				return new ErroValidacao(e.getMessage(), campo, valor.toString());
			}
		}
		return new ErroValidacao(mensagem, campo, valor.toString());
	}

}
