package br.edu.infnet.apilog;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.infnet.apilog.model.domain.Log;

@SpringBootApplication
public class ApiLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiLogApplication.class, args);

	}

}
