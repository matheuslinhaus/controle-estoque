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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.linhaus.controle_estoque.entities.Vape;
import br.com.linhaus.controle_estoque.services.VapeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "vapes")
public class VapeResource {

	@Autowired
	private VapeService service;

	@Operation(summary = "Buscar todos vapes", description = "Método para buscar todos os vapes no Banco de dados", tags = "Vape")
	@GetMapping
	public ResponseEntity<List<Vape>> findAll() {
		List<Vape> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@Operation(summary = "Buscar vape por Id", description = "Método para buscar vape por Id no Banco de dados", tags = "Vape")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Vape> findById(@PathVariable Long id) {
		Vape obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@Operation(summary = "Criar vape", description = "Método para criar vape no Banco de dados uma nova camisa", tags = "Vape", responses = {
			@ApiResponse(responseCode = "201", description = "Inserido com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(example = ""))) })
	@PostMapping
	public ResponseEntity<Vape> insert(@RequestBody Vape obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@Operation(summary = "Deletar vape", description = "Método para deletar vape no Banco de dados", tags = "Vape")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@Operation(summary = "Editar vape", description = "Método para editar vape no Banco de dados", tags = "Vape")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Vape> update(@PathVariable Long id, @RequestBody Vape obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}