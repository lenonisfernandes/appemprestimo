package br.edu.infnet.apiemprestimo.exceptions;

public class QuantidadeAluguelNegativaException extends Exception {
	
	private static final long serialVersionUID = 1L;	
	
	public QuantidadeAluguelNegativaException(String mensagem) {
		super(mensagem);
	}
}
