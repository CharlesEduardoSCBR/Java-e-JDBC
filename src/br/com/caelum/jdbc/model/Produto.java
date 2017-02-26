package br.com.caelum.jdbc.model;

public class Produto {

	Integer id;
	String descricao;
	String nome;

	public Produto() {
		super();
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
	
	public void setId(Integer id){
		this.id = id;
	}
}
