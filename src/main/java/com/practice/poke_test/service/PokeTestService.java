package com.practice.poke_test.service;

import com.practice.poke_test.client.PokemonApiClient;
import com.practice.poke_test.model.PokeDTO;
import com.practice.poke_test.model.TestValuesDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@AllArgsConstructor
public class PokeTestService {
    /**
     * Generates a list of Pokemon based on the provided TestValues.
     * This method is a placeholder and should be implemented with actual logic.
     * testValuesDTO the input values for generating the dream team
     * List of PokeDTO representing the dream team
     */
    private final PokemonApiClient pokemonApiClient;

    public List<PokeDTO> getDreamTeam(TestValuesDTO testValuesDTO) {
        if (testValuesDTO == null) {
            throw new IllegalArgumentException("TestValuesDTO cannot be null");
        }
        PokeDTO pokemon1 = getPokemonByInitialType(testValuesDTO.getTipoInicial());
        PokeDTO pokemon2 = getPokemonByMostWantedPlaceToVisit(testValuesDTO.getPaisQuieroVisitar());
        PokeDTO pokemon3 = getPokemonSpicyOrSweet(testValuesDTO.isPicanteOdulce() ? "picante" : "dulce");

        return List.of(pokemon1, pokemon2, pokemon3);
    }

    private PokeDTO getPokemonByInitialType(String tipoInicial) {
        List<String> listOfCandidates = pokemonApiClient.getPokemonByType(tipoInicial);
        int randomIndex = ThreadLocalRandom.current().nextInt(listOfCandidates.size());
        return pokemonApiClient.getPokemonByName(listOfCandidates.get(randomIndex));
    }

    private PokeDTO getPokemonSpicyOrSweet(String picanteOdulce){
        String Type;
        if (picanteOdulce.equals("picante")) {
            Type = "fire";
        } else{
            Type = "Steel";
        }
        List<String> listOfCandidates = pokemonApiClient.getPokemonByType(Type);
        int randomIndex = ThreadLocalRandom.current().nextInt(listOfCandidates.size());
        return pokemonApiClient.getPokemonByName(listOfCandidates.get(randomIndex));
    }

    private PokeDTO getPokemonByMostWantedPlaceToVisit(String mostWantedPlaceToVisit) {
        int regionStart = 0;
        int regionFinish = 0;
        switch (mostWantedPlaceToVisit) {
            case "Tokio", "Singapur" -> {
                regionStart = 1;
                regionFinish = 151; // Kanto
            }
            case "Osaka", "Seul" -> {
                regionStart = 152;
                regionFinish = 251; // Johto
            }
            case "Londres", "Madrid" -> {
                regionStart = 252;
                regionFinish = 386; // Hoenn
            }
            case "París", "Berlín" -> {
                regionStart = 387;
                regionFinish = 493; // Sinnoh
            }
            case "Nueva York", "Los Ángeles" -> {
                regionStart = 494;
                regionFinish = 649; // Unova
            }
            case "Bruselas", "Ámsterdam" -> {
                regionStart = 650;
                regionFinish = 721; // Kalos
            }
            case "Honolulu", "Bora Bora" -> {
                regionStart = 722;
                regionFinish = 809; // Alola
            }
            case "Edimburgo", "Dublín" -> {
                regionStart = 810;
                regionFinish = 905; // Galar
            }
            case "Barcelona", "Valencia" -> {
                regionStart = 906;
                regionFinish = 1008; // Paldea
            }
        }
        int idRandomFromRegion = ThreadLocalRandom.current().nextInt(regionStart, regionFinish);
        return pokemonApiClient.getPokemonById(idRandomFromRegion);
    }
}
