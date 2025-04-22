package com.damba.apigateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

import java.net.URI;
import java.time.Instant;

@RestController
public class FallbackController {

    @RequestMapping("/fallback/default")
    public ResponseEntity<Problem> handleDefaultFallback(ServerWebExchange exchange) {
        var problem= Problem.builder()
                .withType(URI.create("https://your-api.com/errors/service-unavailable"))
                .withTitle("Service Unavailable")
                .withStatus(Status.SERVICE_UNAVAILABLE)
                .withDetail("Service exceeded failure threshold")
                .withInstance(URI.create(exchange.getRequest().getPath().value()))
                .with("timestamp", Instant.now())
                .with("retry_after", 30) // seconds
                .with("circuit_breaker_state", "OPEN")
                .build();
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(problem);
    }
}
