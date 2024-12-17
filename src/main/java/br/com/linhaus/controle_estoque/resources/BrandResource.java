package br.com.linhaus.controle_estoque.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.linhaus.controle_estoque.entities.Brand;
import br.com.linhaus.controle_estoque.services.BrandService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "brands")
public class BrandResource {

	@Autowired
	private BrandService service;

	@Operation(summary = "Buscar todas marcas", description = "Método para buscar todas as marcas no Banco de dados", tags = "Brand")
	@GetMapping
	public ResponseEntity<List<Brand>> findAll() {
		List<Brand> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}