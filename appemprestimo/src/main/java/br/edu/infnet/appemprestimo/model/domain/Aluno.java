package br.edu.infnet.appemprestimo.model.domain;

public class Aluno {
	
	private String nome;
	private String email;
	private int idade;
	private float mensalidade;
	
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public float getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(float mensalidade) {
		this.mensalidade = mensalidade;
	}

	private String curso;
	private String[] disciplinas;
	private String regiao;
	
	public Aluno(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return String.format("[%s] O aluno %s (%s) tem %d anos, paga R$%.2f de mensalidade e mora na regi�o %s est� inscrito em %d disciplinas!", 
				this.getCurso(),
				this.getNome(),
				this.getEmail(), 
				this.getIdade(),
				this.getMensalidade(),
				this.getRegiao(),
				this.getDisciplinas().length);
	}
	
	public void impressao() {
		System.out.println(this);
		
		for(String disc : this.getDisciplinas()) {
			System.out.println("- "+disc);
		}
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

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String[] getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(String[] disciplinas) {
		this.disciplinas = disciplinas;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	
	

}
