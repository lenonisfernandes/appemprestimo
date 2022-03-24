package br.edu.infnet.dashboard.model.domain;

import br.edu.infnet.dashboard.model.exceptions.QuantidadeAluguelNegativaException;

public class Revista extends Material {
	
	private Integer ano;
	private Integer mes;
	private Integer edicao;

	public Revista() {
		super();
	}
	
	public Revista(String titulo, Integer ano, Integer mes, Integer edicao) {
		super(titulo, null);
		this.ano = ano;
		this.mes = mes;
		this.edicao = edicao;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer restante() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getEdicao() {
		return edicao;
	}

	public void setEdicao(Integer edicao) {
		this.edicao = edicao;
	}

	public void setAlugado(Integer alugado) throws QuantidadeAluguelNegativaException {
	//	if (alugado < 0) {
	//		throw new QuantidadeAluguelNegativaException("Não há quantidades negativas de materiais alugados.");
	//	}
		if(alugado==null) {
			this.alugado = 0;
		}
		else {
			this.alugado = alugado;
		}
	}


}
