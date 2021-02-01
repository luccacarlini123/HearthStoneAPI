package com.mouzetech.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mouzetech.dto.EnumDTO;
import com.mouzetech.enumeration.Classe;
import com.mouzetech.enumeration.Tipo;

@Path("/enum")
@Produces(MediaType.APPLICATION_JSON)
public class EnumResource {

	@GET
	@Path("/tipos")
	public List<EnumDTO> findAllTipo(){
		List<EnumDTO> lista = new ArrayList<>();
		for(Tipo x: Tipo.values()) {
			lista.add(new EnumDTO(x.getId(), x.getDescricao()));
		}
		return lista;
	}
	
	@GET
	@Path("/classes")
	public List<EnumDTO> findAllClasses(){
		List<EnumDTO> lista = new ArrayList<>();
		for(Classe x: Classe.values()) {
			lista.add(new EnumDTO(x.getId(), x.getDescricao()));
		}
		return lista;
	}
}