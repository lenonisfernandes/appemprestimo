package br.edu.infnet.apiemprestimo.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.apiemprestimo.exceptions.QuantidadeAcademicoAlugadoException;

@Entity
@Table(name="TAcademico")
public class Academico extends Material {
	
	private Boolean nacional;
	private String idioma;
	private String tipo;
	// lingaguem
	// tipo - artigo, tcc, resumo 

	public Academico() {
	}
	
	public Academico(String titulo, String autor, Boolean nacional) {
		super(titulo, autor);
		this.nacional = nacional;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Boolean getNacional() {
		return nacional;
	}
	
	@Override
	public void setAlugado(Integer alugado) throws QuantidadeAcademicoAlugadoException {
		if (alugado != 0 && alugado != 1) {
			throw new QuantidadeAcademicoAlugadoException("Materias acadêmicos não podem ter mais de uma cópia alugadas.");
		}
		this.alugado = alugado;
	}

	public void setNacional(Boolean nacional) {
		this.nacional = nacional;
	}

	//TODO No método abstrato, crie uma regra de negócio que utilize atributos 
	//da filha e da mãe.
	@Override
	public Integer restante() {
		return 1 - this.getAlugado();
	}
	
	public String toString() {
		StringBuilder texto = new StringBuilder();
		
		texto.append(super.toString());
		texto.append("; ");
		texto.append(this.nacional);
		
		return texto.toString();
	}

}