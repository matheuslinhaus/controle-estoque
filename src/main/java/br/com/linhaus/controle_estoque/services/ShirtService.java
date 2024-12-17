package br.com.linhaus.controle_estoque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.linhaus.controle_estoque.entities.Brand;
import br.com.linhaus.controle_estoque.entities.Shirt;
import br.com.linhaus.controle_estoque.repositories.BrandRepository;
import br.com.linhaus.controle_estoque.repositories.ShirtRepository;
import br.com.linhaus.controle_estoque.services.exceptions.DatabaseException;
import br.com.linhaus.controle_estoque.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ShirtService {

	@Autowired
	private ShirtRepository shirtRepository;
	
	@Autowired
	private BrandRepository brandRepository;

	public List<Shirt> findAll() {
		return shirtRepository.findAll();
	}

	public Shirt findById(Long id) {
		return shirtRepository.findById(id).orElse(null);
	}

	public Shirt insert(Shirt shirt) {
		Brand brand = brandRepository.findById(shirt.getBrand().getId())
	            .orElseThrow(() -> new RuntimeException("Marca não encontrada"));
		shirt.setBrand(brand);
		return shirtRepository.save(shirt);
	}

	public void delete(Long id) {
		if (!shirtRepository.existsById(id)) {
			throw new ResourceNotFoundException(id);
		}
		try {
			shirtRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Shirt update(Long id, Shirt obj) {
		try {
			Shirt entity = shirtRepository.getReferenceById(id);
			updateData(entity, obj);
			return shirtRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
	}

	private void updateData(Shirt entity, Shirt obj) {
		entity.setColor(obj.getColor());
		entity.setSize(obj.getSize());
		entity.setPrinted(obj.getPrinted());
		entity.setMaterial(obj.getMaterial());

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
