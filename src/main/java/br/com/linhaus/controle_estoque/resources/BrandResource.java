package br.com.linhaus.controle_estoque.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.linhaus.controle_estoque.entities.Brand;
import br.com.linhaus.controle_estoque.entities.Vape;
import br.com.linhaus.controle_estoque.entities.enums.ProductType;
import br.com.linhaus.controle_estoque.services.BrandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "brands")
public class BrandResource {

	@Autowired
	private BrandService service;

	@Operation(summary = "Buscar todas marcas", description = "Método para buscar todas as marcas no Banco de dados", tags = "Brand")
	@GetMapping("/")
	public ResponseEntity<List<Brand>> findAll() {
		List<Brand> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@Operation(summary = "Buscar marcas pelo tipo", description = "Método para buscar marcas no Banco de dados pelo tipo", tags = "Brand")
	@GetMapping()
	public List<Brand> getBrandsByProductType(@RequestParam int productType) {
		return service.findByProductType(ProductType.valueOf(productType));
	}
	
	@Operation(summary = "Criar marca", description = "Método para criar marca no Banco de dados uma nova camisa", tags = "Brand", responses = {
			@ApiResponse(responseCode = "201", description = "Inserido com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(example = ""))) })
	@PostMapping
	public ResponseEntity<Brand> insert(@RequestBody Brand obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@Operation(summary = "Deletar marca", description = "Método para deletar marca no Banco de dados", tags = "Brand")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@Operation(summary = "Editar marca", description = "Método para editar marca no Banco de dados", tags = "Brand")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Brand> update(@PathVariable Long id, @RequestBody Brand obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}