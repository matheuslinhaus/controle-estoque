package br.com.linhaus.controle_estoque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.linhaus.controle_estoque.entities.Brand;
import br.com.linhaus.controle_estoque.entities.Shoes;
import br.com.linhaus.controle_estoque.repositories.BrandRepository;
import br.com.linhaus.controle_estoque.repositories.ShoesRepository;
import br.com.linhaus.controle_estoque.services.exceptions.DatabaseException;
import br.com.linhaus.controle_estoque.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ShoesService {

	@Autowired
	private ShoesRepository shoesRepository;
	
	@Autowired
	private BrandRepository brandRepository;

	public List<Shoes> findAll() {
		return shoesRepository.findAll();
	}

	public Shoes findById(Long id) {
		return shoesRepository.findById(id).orElse(null);
	}

	public Shoes insert(Shoes shoes) {
		Brand brand = brandRepository.findById(shoes.getBrand().getId())
	            .orElseThrow(() -> new RuntimeException("Marca não encontrada"));
		shoes.setBrand(brand);
		return shoesRepository.save(shoes);
	}

	public void delete(Long id) {
		if (!shoesRepository.existsById(id)) {
			throw new ResourceNotFoundException(id);
		}
		try {
			shoesRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Shoes update(Long id, Shoes obj) {
		try {
			Shoes entity = shoesRepository.getReferenceById(id);
			updateData(entity, obj);
			return shoesRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
	}

	private void updateData(Shoes entity, Shoes obj) {
		entity.setColor(obj.getColor());
		entity.setSize(obj.getSize());

		entity.setDescription(obj.getDescription());
		entity.setFullDescription(obj.getFullDescription());
		Brand brand = brandRepository.findById(obj.getBrand().getId())
	            .orElseThrow(() -> new RuntimeException("Marca não encontrada"));
		entity.setBrand(brand);
		entity.setPrice(obj.getPrice());
		entity.setQuantity(obj.getQuantity());
		entity.setUrlImage(obj.getUrlImage());
	}
}
