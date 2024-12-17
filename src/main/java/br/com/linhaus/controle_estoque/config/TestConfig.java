package br.com.linhaus.controle_estoque.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.linhaus.controle_estoque.entities.Shirt;
import br.com.linhaus.controle_estoque.repositories.ShirtRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ShirtRepository camisaRepository;

	@Override
	public void run(String... args) throws Exception {

		Shirt cams = new Shirt("Blusa Gola Careca", "Blusa de Gola Careca cor Preta", "Nike", 50.00, 10, "", null,
				"Preto", "M", false, "Poliester");
		camisaRepository.save(cams);
	}

}
