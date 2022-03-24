package br.edu.infnet.appemprestimo.model.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import br.edu.infnet.appemprestimo.exceptions.QuantidadeAcademicoAlugadoException;
import br.edu.infnet.appemprestimo.exceptions.QuantidadeAluguelNegativaException;

@JsonTypeInfo(
		use=JsonTypeInfo.Id.NAME, 
		include=JsonTypeInfo.As.PROPERTY, 
		property="tipo")
@JsonSubTypes({
	@JsonSubTypes.Type(value= Academico.class, name = "Academico"), 
	@JsonSubTypes.Type(value= Livro.class, name = "Livro"), 
	@JsonSubTypes.Type(value= Revista.class, name = "Revista")})
public abstract class Material {
	
	private Integer id;
	private String titulo;
	private String autor;
	protected Integer alugado;
	private Usuario usuario;
	private List<Emprestimo> emprestimos;
	
	public Material() {
		
	}
	
	public Material (String titulo, String autor) {
		this.titulo = titulo;
		this.autor = autor;
	}

	

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public Integer getAlugado() {
		return alugado;
	}
	
	public abstract Integer restante();
	
	public String toString() {
		StringBuilder texto = new StringBuilder();
		
		texto.append(this.id);
		texto.append("; ");
		texto.append(this.titulo);
		texto.append("; ");
		texto.append(this.autor);
		texto.append("; ");
		texto.append(this.alugado);
		
		return texto.toString();
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setAlugado(Integer alugado) throws QuantidadeAluguelNegativaException, QuantidadeAcademicoAlugadoException {
		this.alugado = alugado;
	}
	
	

}
