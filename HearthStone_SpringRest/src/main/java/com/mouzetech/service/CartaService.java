package com.mouzetech.service;

import org.springframework.stereotype.Service;

import com.mouzetech.dto.CartaNewDTO;
import com.mouzetech.enumeration.Classe;
import com.mouzetech.enumeration.Tipo;
import com.mouzetech.model.Carta;

@Service
public class CartaService {
	
	public static Carta fromNewDTO(CartaNewDTO dto) {
		return new Carta(null, dto.getNome(), dto.getDescricao(), dto.getAtaque(), 
				dto.getDefesa(), Tipo.toEnum(dto.getTipo()), Classe.toEnum(dto.getClasse()));
	}
	
}