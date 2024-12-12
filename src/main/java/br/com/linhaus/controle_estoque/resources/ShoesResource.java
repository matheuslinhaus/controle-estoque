package br.com.linhaus.controle_estoque.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.linhaus.controle_estoque.entities.Shoes;
import br.com.linhaus.controle_estoque.services.ShoesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping(value = "shoes")
public class ShoesResource {

	@Autowired
	private ShoesService service;

	@Operation(summary = "Buscar todos tênis", description = "Método para buscar todos os tênis no Banco de dados", tags = "Shoes")
	@GetMapping
	public ResponseEntity<List<Shoes>> findAll() {
		List<Shoes> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@Operation(summary = "Buscar tênis por Id", description = "Método para buscar tênis por Id no Banco de dados", tags = "Shoes")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Shoes> findById(@PathVariable Long id) {
		Shoes obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@Operation(summary = "Criar tênis", description = "Método para criar tênis no Banco de dados uma nova camisa", tags = "Shoes", responses = {
			@ApiResponse(responseCode = "201", description = "Inserido com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(example = ""))) })
	@PostMapping
	public ResponseEntity<Shoes> insert(@RequestBody Shoes obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@Operation(summary = "Deletar tênis", description = "Método para deletar tênis no Banco de dados", tags = "Shoes")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@Operation(summary = "Editar tênis", description = "Método para editar tênis no Banco de dados", tags = "Shoes")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Shoes> update(@PathVariable Long id, @RequestBody Shoes obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}