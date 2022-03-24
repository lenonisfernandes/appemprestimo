package br.edu.infnet.apiemprestimo.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TEmprestimo")
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime data;
	private String descricao;
	private boolean web;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="idcliente")
	private Cliente cliente;
	
	@ManyToMany(cascade = CascadeType.DETACH)
	private List<Material> materiais;
	
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;
		
	public Emprestimo() {
		this.data = LocalDateTime.now();
		this.materiais = new ArrayList<Material>();
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public void setData(LocalDateTime data) {
		this.data = data;
	}


	public String toString() {
		String texto;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		texto = String.format("%d; %s; %s; %s; %s; %d", 
				this.id, 
				this.data.format(formato),
				this.descricao,
				this.web,
				this.cliente,
				this.materiais.size());
		return texto;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isWeb() {
		return web;
	}

	public void setWeb(boolean web) {
		this.web = web;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Material> getMateriais() {
		return materiais;
	}

	public void setMateriais(List<Material> materiais) {
		this.materiais = materiais;
	}
	
	public void addMateriais(Material material) {
		this.materiais.add(material);
	}

}
