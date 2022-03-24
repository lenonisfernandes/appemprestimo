package br.edu.infnet.dashboard.model.domain;

import br.edu.infnet.dashboard.model.exceptions.QuantidadeAluguelNegativaException;

public class Livro extends Material {

	Integer edicao;
	Integer ano;
	Integer qnt;
	
	public Livro() {
		super();
	}
	
	public Livro(String titulo, String autor, 
			Integer edicao, Integer ano, Integer qnt) {
		super(titulo, autor);
		this.edicao = edicao;
		this.ano = ano;
		this.qnt = qnt;
	}
	
	public Integer getEdicao() {
		return edicao;
	}

	public Integer getAno() {
		return ano;
	}

	public Integer getQnt() {
		return qnt;
	}
	
	public void setQnt(Integer qnt) {
		this.qnt = qnt;
	}
	
	public void setEdicao(Integer edicao) {
		this.edicao = edicao;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	@Override
	public Integer restante() {
		return this.qnt - this.getAlugado();
	}
	
	public String toString() {
		StringBuilder texto = new StringBuilder();
		
		texto.append(super.toString());
		texto.append("; ");
		texto.append(this.edicao);
		texto.append("; ");
		texto.append(this.ano);
		texto.append("; ");
		texto.append(this.qnt);
		
		return texto.toString();
		
	}
	
	@Override
	public void setAlugado(Integer alugado) throws QuantidadeAluguelNegativaException {
//		if (alugado < 0) {
//			throw new QuantidadeAluguelNegativaException("Não há quantidades negativas de materiais alugados.");
//		}
		this.alugado = alugado;
	}
	
	
}
