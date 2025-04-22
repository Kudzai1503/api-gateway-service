package com.damba.apigateway.config;

import org.zalando.problem.jackson.ProblemModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProblemConfig {
    
    @Bean
    public ProblemModule problemModule() {
        return new ProblemModule()
            .withStackTraces(false);
    }
}