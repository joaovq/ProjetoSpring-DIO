package com.project.ProjetoSpringDIO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

// @see acessar aqui "http://127.0.0.1:8080/swagger-ui/index.html#/"
// @author joaovq
@EnableFeignClients
@SpringBootApplication
public class ProjetoSpringDioApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProjetoSpringDioApplication.class, args);
	}

}
