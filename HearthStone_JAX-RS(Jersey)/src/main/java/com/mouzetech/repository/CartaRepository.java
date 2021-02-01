package com.mouzetech.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouzetech.enumeration.Classe;
import com.mouzetech.enumeration.Tipo;
import com.mouzetech.model.Carta;

@Repository
public interface CartaRepository extends JpaRepository<Carta, Long> {
	
	Optional<Carta> findByNome(String nome);
	
	List<Carta> findByTipo(Tipo tipo);
	
	List<Carta> findByClasse(Classe classe);
	
}