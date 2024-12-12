package br.com.linhaus.controle_estoque.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI customAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Estoque API")
						.version("1.0.0")
						.description("Api para controle de estoque de produtos"));
	}

}
