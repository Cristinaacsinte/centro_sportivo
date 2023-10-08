package it.euris.javaacademy.centro_sportivo_CA;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Centro Sportivo API", version = "1.0", description = "Centro Sportivo management"))
@SecurityScheme(name = "authentication", scheme = "basic", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class CentroSportivoCaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentroSportivoCaApplication.class, args);
	}

}
