package br.com.linhaus.controle_estoque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.linhaus.controle_estoque.entities.Brand;
import br.com.linhaus.controle_estoque.repositories.BrandRepository;
import br.com.linhaus.controle_estoque.services.exceptions.DatabaseException;
import br.com.linhaus.controle_estoque.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class BrandService {

	@Autowired
	private BrandRepository brandRepository;

	public List<Brand> findAll() {
		return brandRepository.findAll();
	}

	public Brand insert(Brand brand) {
		return brandRepository.save(brand);
	}

	public void delete(Long id) {
		if (!brandRepository.existsById(id)) {
			throw new ResourceNotFoundException(id);
		}
		try {
			brandRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Brand update(Long id, Brand obj) {
		try {
			Brand entity = brandRepository.getReferenceById(id);
			updateData(entity, obj);
			return brandRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
	}

	private void updateData(Brand entity, Brand obj) {
		entity.setName(obj.getName());

	}

}