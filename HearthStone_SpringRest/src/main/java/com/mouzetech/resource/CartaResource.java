package com.mouzetech.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mouzetech.dto.CartaNewDTO;
import com.mouzetech.enumeration.Classe;
import com.mouzetech.enumeration.Tipo;
import com.mouzetech.exception.ObjectNotFoundException;
import com.mouzetech.model.Carta;
import com.mouzetech.repository.CartaRepository;
import com.mouzetech.service.CartaService;

@RestController
@RequestMapping("/carta")
public class CartaResource {

	@Autowired
	private CartaRepository repository;
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<Carta> findAll(){
		return repository.findAll();
	}
	
	@GetMapping("/id/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public Carta findById(@PathVariable("id") Long id) {
		return repository.findById(id)
				.orElseThrow( () -> new ObjectNotFoundException("Carta com id "+id+" não encontrada"));
	}
	
	@GetMapping("/nome/{nome}")
	@ResponseStatus(value = HttpStatus.OK)
	public Carta findByNome(@PathVariable("nome") String nome) {
		return repository.findByNome(nome)
				.orElseThrow( () -> new ObjectNotFoundException("Carta com nome "+nome+" não encontrada"));
	}
	
	@GetMapping("/tipoId/{tipoId}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Carta> findByTipo(@PathVariable("tipoId") Integer tipoId) {
		return repository.findByTipo(Tipo.toEnum(tipoId));
	}
	
	@GetMapping("/classeId/{classeId}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<Carta> findByClasse(@PathVariable("classeId") Integer classeId) {
		return repository.findByClasse(Classe.toEnum(classeId));
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Carta create(@RequestBody @Valid CartaNewDTO cartaDTO) {	
		return repository.save(CartaService.fromNewDTO(cartaDTO));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
		repository.delete(repository.findById(id).orElseThrow( () -> new ObjectNotFoundException("Carta com id "+id+" não encontrada, impossível excluir")));
		return ResponseEntity.noContent().build();
	}
}