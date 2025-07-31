package com.practice.poke_test.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.practice.poke_test.model.PokeDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@AllArgsConstructor
public class PokemonApiClient {

    private final WebClient webClient;

    public PokeDTO getPokemonById(Integer id) {
        // Placeholder for actual implementation
        return webClient.get()
                .uri("/pokemon/" + id)
                .retrieve()
                .bodyToMono(PokeDTO.class)
                .block();
    }

    public PokeDTO getPokemonByName(String name) {
        // Placeholder for actual implementation
        return webClient.get()
                .uri("/pokemon/" + name)
                .retrieve()
                .bodyToMono(PokeDTO.class)
                .block();
    }

    public List<String> getPokemonByType(String tipoInicial) {
        return webClient.get()
                .uri("/type/" + tipoInicial)
                .retrieve()
                .bodyToMono(JsonNode.class)
                .map(json -> {
                    List<String> pokemonNames = new java.util.ArrayList<>();
                    JsonNode pokemonNode = json.get("pokemon");
                    if (pokemonNode != null && pokemonNode.isArray()) {
                        for (JsonNode poke : pokemonNode) {
                            JsonNode nameNode = poke.get("pokemon").get("name");
                            if (nameNode != null && nameNode.isTextual()) {
                                pokemonNames.add(nameNode.asText());
                            }
                        }
                    }
                    return pokemonNames;
                }).block();
    }


    /*
    * Este es el approach para jalar los valores de la lista que requiero
    * sin jalar completo el objeto PokeDTO.
    *
    * Mono<List<String>> roleNamesMono = webClient.get()
    .uri("https://api.ejemplo.com/usuario")
    .retrieve()
    .bodyToMono(JsonNode.class)
    .map(json -> {
        List<String> names = new ArrayList<>();
        JsonNode rolesNode = json.get("roles");
        if (rolesNode != null && rolesNode.isArray()) {
            for (JsonNode role : rolesNode) {
                JsonNode nameNode = role.get("name");
                if (nameNode != null && nameNode.isTextual()) {
                    names.add(nameNode.asText());
                }
            }
        }
        return names;
    });
    *
    * */
}
