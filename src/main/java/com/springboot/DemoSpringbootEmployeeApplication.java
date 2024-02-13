package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "ORDER-SERVICE OPEN API",
				version = "1.0.0",
				description = "ORDER OPEN API documentation"
				),
				servers = @Server(
						url = "http://localhost:8080",
						description = "Order-service OPEN API url"
				)
				
		)

public class DemoSpringbootEmployeeApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(DemoSpringbootEmployeeApplication.class, args);
	}

}
