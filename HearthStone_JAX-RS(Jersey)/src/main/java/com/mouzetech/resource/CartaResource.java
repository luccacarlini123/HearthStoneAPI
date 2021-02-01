package com.mouzetech.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.mouzetech.dto.CartaNewDTO;
import com.mouzetech.enumeration.Classe;
import com.mouzetech.enumeration.Tipo;
import com.mouzetech.exception.IdNotFoundException;
import com.mouzetech.exception.NomeNotFoundException;
import com.mouzetech.exception.NotValidFieldException;
import com.mouzetech.repository.CartaRepository;
import com.mouzetech.resource.exception.FieldMessage;
import com.mouzetech.resource.exception.ValidationError;
import com.mouzetech.service.CartaService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/carta")
public class CartaResource {

	@Context
	private UriInfo info;
	
	@Autowired
	private CartaRepository repository;
	
	@GET
	public Response findAll(){
		return Response.status(Response.Status.OK)
				.entity(repository.findAll())
				.build();
	}
	
	@GET
	@Path("/id/{id}")
	public Response findById(@PathParam("id") Long id) {
		return Response.status(Response.Status.OK)
				.entity(repository.findById(id)
						.orElseThrow( () -> new IdNotFoundException("Carta com id "+id+" não encontrada")))
				.build();
				
	}
	
	@GET
	@Path("/nome/{nome}")
	public Response findByNome(@PathParam("nome") String nome) {
		
		return Response.status(Response.Status.OK)
				.entity(repository.findByNome(nome)
						.orElseThrow( () -> new NomeNotFoundException("Carta com nome "+nome+" não encontrada")))
				.build();
	}
	
	@GET
	@Path("/tipoId/{tipoId}")
	public Response findByTipo(@PathParam("tipoId") Integer tipoId) {
		return Response.status(Response.Status.OK)
				.entity(repository.findByTipo(Tipo.toEnum(tipoId)))
				.build();
	}
	
	@GET
	@Path("/classeId/{classeId}")
	public Response findByClasse(@PathParam("classeId") Integer classeId) {
		return Response.status(Response.Status.OK)
				.entity(repository.findByClasse(Classe.toEnum(classeId)))
				.build();

	}
	
	@POST
	public Response create(CartaNewDTO dto) {	
		int flag = 0;
		List<FieldMessage> messages = new ArrayList<>();
		if( StringUtils.isBlank(dto.getNome()) || StringUtils.isBlank(dto.getDescricao()) ||
			dto.getAtaque() == null || dto.getDefesa() == null || dto.getTipo() == null || dto.getClasse() == null){
			messages.add(new FieldMessage("Não é permitido valores nulos ou em branco"));
			flag++;
		}
		if( dto.getAtaque() < 0 || dto.getDefesa() < 0) {
			messages.add(new FieldMessage("Não é permitido valores menor que 0 para os campos Ataque e Defesa"));
			flag++;
		}
		if( dto.getAtaque() > 10 || dto.getDefesa() > 10) {
			messages.add(new FieldMessage("Não é permitido valores maior que 10 para os campos Ataque e Defesa"));
			flag++;
		}
		if(flag > 0) {
			ValidationError error = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro ao processar entidade", 
					"Entidade não processável, há valores inválidos ou nulos", info.getAbsolutePath().toString(), messages);
			throw new NotValidFieldException(error);
		}
		return Response.status(Response.Status.CREATED)
				.entity(repository.save(CartaService.fromNewDTO(dto)))
				.build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteById(@PathParam("id") Long id) {
		repository.delete(repository.findById(id).orElseThrow( () -> new IdNotFoundException("Carta com id "+id+" não encontrada, impossível excluir")));
		return Response.status(Response.Status.NO_CONTENT)
				.entity(null)
				.build();
	}
	
}
