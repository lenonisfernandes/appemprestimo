package br.edu.infnet.apimaterial.exceptions;

public class QuantidadeAluguelNegativaException extends Exception {
	
	private static final long serialVersionUID = 1L;	
	
	public QuantidadeAluguelNegativaException(String mensagem) {
		super(mensagem);
	}
}
