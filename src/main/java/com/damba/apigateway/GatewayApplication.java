package com.damba.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

//	@Bean
//	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route(r -> r.path("/**")
//						.filters(f -> f
//							.prefixPath("/api/v1")
//							.addResponseHeader("X-Powered-By","Damba Gateway Service")
//						)
//						.uri("http://localhost:8089")
//				)
//				.build();
//	}

}
