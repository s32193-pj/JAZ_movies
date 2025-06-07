package com.s32193.spring_movies;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Wypozyczalnia Mobie",
				description = "Aplikacja do zarządzania wypożyczalnią filmów"
		)
)
public class SpringMoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMoviesApplication.class, args);
	}

}
