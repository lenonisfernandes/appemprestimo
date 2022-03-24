package br.edu.infnet.apiusuario.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import br.edu.infnet.apiusuario.exceptions.QuantidadeAcademicoAlugadoException;
import br.edu.infnet.apiusuario.exceptions.QuantidadeAluguelNegativaException;

@Entity
@Table(name="TMaterial")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(
		use=JsonTypeInfo.Id.NAME, 
		include=JsonTypeInfo.As.PROPERTY, 
		property="tipo")
@JsonSubTypes({
	@JsonSubTypes.Type(value= Academico.class, name = "Academico"), 
	@JsonSubTypes.Type(value= Livro.class, name = "Livro"), 
	@JsonSubTypes.Type(value= Revista.class, name = "Revista")})
public abstract class Material {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String autor;
	protected Integer alugado;
	
	@ManyToOne
	@JoinColumn(name="idusuario")
	@JsonIgnore
	private Usuario usuario;
	
	@ManyToMany(mappedBy="materiais")
	@JsonIgnore
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
