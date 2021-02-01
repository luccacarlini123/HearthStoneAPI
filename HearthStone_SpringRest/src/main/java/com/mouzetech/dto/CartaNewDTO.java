package com.mouzetech.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CartaNewDTO {
	
	@NotBlank(message = "{campo.nome.obrigatorio}")
	private String nome;
	
	@NotBlank(message = "{campo.descricao.obrigatorio}")
	private String descricao;
	
	@Min(value = 0, message = "{campo.ataque.min}")
	@Max(value = 10, message = "{campo.ataque.max}")
	@NotNull(message = "{campo.ataque.obrigatorio}")
	private Integer ataque;
	
	@Min(value = 0, message = "{campo.defesa.min}")
	@Max(value = 10, message = "{campo.defesa.max}")
	@NotNull(message = "{campo.defesa.obrigatorio}")
	private Integer defesa;
	
	@NotNull(message = "{campo.tipo.obrigatorio}")
	private Integer tipo;
	
	@NotNull(message = "{campo.classe.obrigatrio}")
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