package com.mouzetech.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mouzetech.dto.EnumDTO;
import com.mouzetech.enumeration.Classe;
import com.mouzetech.enumeration.Tipo;

@RestController
@RequestMapping("/enum")
public class EnumResource {

	@GetMapping("/tipos")
	public List<EnumDTO> findAllTipo(){
		List<EnumDTO> lista = new ArrayList<>();
		for(Tipo x: Tipo.values()) {
			lista.add(new EnumDTO(x.getId(), x.getDescricao()));
		}
		return lista;
	}
	
	@GetMapping("/classes")
	public List<EnumDTO> findAllClasses(){
		List<EnumDTO> lista = new ArrayList<>();
		for(Classe x: Classe.values()) {
			lista.add(new EnumDTO(x.getId(), x.getDescricao()));
		}
		return lista;
	}
}