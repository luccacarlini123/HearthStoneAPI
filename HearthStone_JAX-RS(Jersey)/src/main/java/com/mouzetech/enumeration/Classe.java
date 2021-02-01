package com.mouzetech.enumeration;

import com.mouzetech.exception.IdNotFoundException;

public enum Classe {

	Mago(1, "Mago"),
	Paladino(2, "Paladino"),
	Caçador(3, "Caçador"),
	Druida(4, "Druida"),
	Qualquer(5, "Qualquer");
	
	private Integer id;
	private String descricao;
	
	private Classe(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static Classe toEnum(Integer id) {
		if(id==null) {
			return null;
		}
		for(Classe x : Classe.values()) {
			if(id.equals(x.getId())) {
				return x;
			}
			System.out.println(x);
		}
		throw new IdNotFoundException("Classe não encontrada para o id "+id);
	}
	
}
