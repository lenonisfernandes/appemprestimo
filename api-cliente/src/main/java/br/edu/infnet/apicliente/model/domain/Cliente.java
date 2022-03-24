package br.edu.infnet.apicliente.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TCliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String cpf;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="idendereco")
	private Endereco endereco;
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;
	
	public Cliente() {
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Cliente(String nome, String email, String cpf) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		StringBuilder texto = new StringBuilder();
		
		texto.append(this.id);
		texto.append(";");
		texto.append(this.nome);
		texto.append(";");
		texto.append(this.email);
		texto.append(";");
		texto.append(this.cpf);
		
		return texto.toString();
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	

}
