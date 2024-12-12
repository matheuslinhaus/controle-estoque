package br.com.linhaus.controle_estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.linhaus.controle_estoque.entities.Shoes;

public interface ShoesRepository extends JpaRepository<Shoes, Long> {
	
}
