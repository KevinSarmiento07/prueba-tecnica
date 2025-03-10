package com.kass.prueba_tecnica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.kass.prueba_tecnica.controllers.AuthController;
import com.kass.prueba_tecnica.controllers.ProductController;

@SpringBootApplication
@Import({AuthController.class, ProductController.class})
public class PruebaTecnicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaTecnicaApplication.class, args);
	}

}
