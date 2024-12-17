package br.com.linhaus.controle_estoque.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.linhaus.controle_estoque.entities.Brand;
import br.com.linhaus.controle_estoque.entities.Shirt;
import br.com.linhaus.controle_estoque.repositories.BrandRepository;
import br.com.linhaus.controle_estoque.repositories.ShirtRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ShirtRepository camisaRepository;


	@Autowired
	private BrandRepository marcaRepository;

	@Override
	public void run(String... args) throws Exception {

		Brand mc0 = new Brand("Nike");
		Brand mc1 = new Brand("Adidas");
		Shirt cams = new Shirt("Blusa Gola Careca", "Blusa de Gola Careca cor Preta", 50.00, 10, "", null,
				mc0, "Preto", "M", false, "Poliester");
		camisaRepository.save(cams);
		marcaRepository.saveAll(Arrays.asList(mc0,mc1));
	}

}
