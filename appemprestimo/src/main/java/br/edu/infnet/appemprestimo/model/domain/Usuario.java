package br.edu.infnet.appemprestimo.model.domain;

import java.util.List;

public class Usuario {
	
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private boolean admin;
	private Endereco endereco;
	private List<Cliente> clientes;
	private List<Material> materiais;
	private List<Emprestimo> emprestimos;
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public List<Material> getMateriais() {
		return materiais;
	}

	public void setMateriais(List<Material> materiais) {
		this.materiais = materiais;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void setSolicitantes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Usuario() {
	}
	
	public Usuario(Integer id) {
		this.id = id;	
	}	
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String toString() {
		return "Olá, "+this.getNome() + " ("+this.getEmail()+")";
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isAdmin() {
		return admin;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	

}
