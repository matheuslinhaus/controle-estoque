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

import br.com.linhaus.controle_estoque.entities.Shirt;
import br.com.linhaus.controle_estoque.services.ShirtService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping(value = "shirts")
public class ShirtResource {

	@Autowired
	private ShirtService service;

	@Operation(summary = "Buscar todas camisas", description = "Método para buscar todas as camisas no Banco de dados", tags = "Shirt")
	@GetMapping
	public ResponseEntity<List<Shirt>> findAll() {
		List<Shirt> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@Operation(summary = "Buscar camisa por Id", description = "Método para buscar camisa por Id no Banco de dados", tags = "Shirt")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Shirt> findById(@PathVariable Long id) {
		Shirt obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@Operation(summary = "Criar camisa", description = "Método para criar camisa no Banco de dados uma nova camisa", tags = "Shirt", responses = {
			@ApiResponse(responseCode = "201", description = "Inserido com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(example = ""))) })
	@PostMapping
	public ResponseEntity<Shirt> insert(@RequestBody Shirt obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@Operation(summary = "Deletar camisa", description = "Método para deletar camisa no Banco de dados", tags = "Shirt")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@Operation(summary = "Editar camisa", description = "Método para editar camisa no Banco de dados", tags = "Shirt")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Shirt> update(@PathVariable Long id, @RequestBody Shirt obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}