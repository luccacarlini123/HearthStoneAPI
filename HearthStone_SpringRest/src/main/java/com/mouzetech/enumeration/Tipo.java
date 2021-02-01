package com.mouzetech.enumeration;

import com.mouzetech.exception.ObjectNotFoundException;

public enum Tipo {
	
	Magia(1, "Magia"),
	Criatura(2, "Criatura");
	
	private Integer id;
	private String descricao;
	
	private Tipo(Integer id, String descricao) {
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
	
	public static Tipo toEnum(Integer id) {
		if(id==null) {
			return null;
		}
		for(Tipo x : Tipo.values()) {
			if(id.equals(x.getId())) {
				return x;
			}
		}
		throw new ObjectNotFoundException("Tipo não encontrado para o id "+id);
	}
	
	//public static String()
	
}