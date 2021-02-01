package com.mouzetech.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mouzetech.enumeration.Classe;
import com.mouzetech.enumeration.Tipo;

@Entity
public class Carta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 80)
	private String nome;
	
	@Column(nullable = false, length = 100)
	private String descricao;
	
	@Column(nullable = false)
	private Integer ataque;
	
	@Column(nullable = false)
	private Integer defesa;

	@Column(nullable = false, length = 30)
	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	@Column(nullable = false, length = 30)
	@Enumerated(EnumType.STRING)
	private Classe classe;

	public Carta() {
	}

	public Carta(Long id, String nome, String descricao, Integer ataque, Integer defesa, Tipo tipo, Classe classe) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.ataque = ataque;
		this.defesa = defesa;
		this.tipo = tipo;
		this.classe = classe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
