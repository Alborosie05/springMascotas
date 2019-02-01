package es.salesianos.springMascotas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages= {"es.salesianos.*"})
public class SpringMascotasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMascotasApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringMascotasApplication.class);
	}
}

