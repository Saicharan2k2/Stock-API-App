package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableDiscoveryClient
@CrossOrigin(origins = "*")
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
	@Bean
    public RouteLocator serviceLocator(RouteLocatorBuilder builder) {
        return builder.
        		routes()
                .route("STOCK-PRICE-SERVICE", r -> r.path("/api/stocks/**")
                .uri("lb://STOCK-PRICE-SERVICE"))
                .route("HISTORY-SERVICE",r -> r.path("/api/history/**")
                .uri("lb://HISTORY-SERVICE"))
                .build();
    }

}
