package br.com.linhaus.controle_estoque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.linhaus.controle_estoque.entities.Brand;
import br.com.linhaus.controle_estoque.entities.Vape;
import br.com.linhaus.controle_estoque.repositories.BrandRepository;
import br.com.linhaus.controle_estoque.repositories.VapeRepository;
import br.com.linhaus.controle_estoque.services.exceptions.DatabaseException;
import br.com.linhaus.controle_estoque.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class VapeService {

	@Autowired
	private VapeRepository vapeRepository;
	
	@Autowired
	private BrandRepository brandRepository;

	public List<Vape> findAll() {
		return vapeRepository.findAll();
	}

	public Vape findById(Long id) {
		return vapeRepository.findById(id).orElse(null);
	}

	public Vape insert(Vape vape) {
		Brand brand = brandRepository.findById(vape.getBrand().getId())
	            .orElseThrow(() -> new RuntimeException("Marca não encontrada"));
		vape.setBrand(brand);
		return vapeRepository.save(vape);
	}

	public void delete(Long id) {
		if (!vapeRepository.existsById(id)) {
			throw new ResourceNotFoundException(id);
		}
		try {
			vapeRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Vape update(Long id, Vape obj) {
		try {
			Vape entity = vapeRepository.getReferenceById(id);
			updateData(entity, obj);
			return vapeRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
	}

	private void updateData(Vape entity, Vape obj) {
		entity.setPuffs(obj.getPuffs());
		entity.setFlavor(obj.getFlavor());

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
