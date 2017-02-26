package br.com.caelum.jdbc.model;

public class Produto {

	Integer id;
	String descricao;
	String nome;
	
	Produto(){
		
	}

	public Produto(String descricao, String nome) {
		super();
		this.descricao = descricao;
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}
}
