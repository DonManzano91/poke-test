package com.practice.poke_test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    String POKE_API_BASE_URL = "https://pokeapi.co/api/v2";

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(POKE_API_BASE_URL)
                .defaultHeader("Accept", "application/json")
                .build();
    }
}
