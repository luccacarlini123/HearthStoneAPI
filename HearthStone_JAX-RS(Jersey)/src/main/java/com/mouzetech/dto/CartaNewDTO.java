package com.mouzetech.dto;

import java.io.Serializable;

public class CartaNewDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String descricao;
	private Integer ataque;
	private Integer defesa;
	private Integer tipo;
	private Integer classe;
	
	public CartaNewDTO() {
	}

	public CartaNewDTO(String nome, String descricao, Integer ataque, Integer defesa, Integer tipo, Integer classe) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.ataque = ataque;
		this.defesa = defesa;
		this.tipo = tipo;
		this.classe = classe;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getAtaque() {
		return ataque;
	}

	public void setAtaque(Integer ataque) {
		this.ataque = ataque;
	}

	public Integer getDefesa() {
		return defesa;
	}

	public void setDefesa(Integer defesa) {
		this.defesa = defesa;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getClasse() {
		return classe;
	}

	public void setClasse(Integer classe) {
		this.classe = classe;
	}
}