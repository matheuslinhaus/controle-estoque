package br.com.linhaus.controle_estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.linhaus.controle_estoque.entities.Vape;

public interface VapeRepository extends JpaRepository<Vape, Long> {
	
}
