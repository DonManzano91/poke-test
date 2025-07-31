package com.practice.poke_test.service;

import com.practice.poke_test.client.PokemonApiClient;
import com.practice.poke_test.model.PokeDTO;
import com.practice.poke_test.model.TestValuesDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@AllArgsConstructor
public class PokeTestService {
    /**
     * Generates a list of Pokemon based on the provided TestValues.
     * This method is a placeholder and should be implemented with actual logic.
     *
     * @param testValuesDTO the input values for generating the dream team
     * @return List of PokeDTO representing the dream team
     */
    private final PokemonApiClient pokemonApiClient;

    public List<PokeDTO> getDreamTeam(TestValuesDTO testValuesDTO) {
        if (testValuesDTO == null) {
            throw new IllegalArgumentException("TestValuesDTO cannot be null");
        }
        PokeDTO pokemon1 = getPokemonByInitialType(testValuesDTO.getTipoInicial());
        //PokeDTO pokemon2 = getPokemonByMostWantedPlaceToVisit(testValuesDTO.getPaisQuieroVisitar());

        return List.of(pokemon1);
    }


    private PokeDTO getPokemonByInitialType(String tipoInicial){
        List<String> listOfCandidates = pokemonApiClient.getPokemonByType(tipoInicial);
        int randomIndex = ThreadLocalRandom.current().nextInt(listOfCandidates.size());
        return pokemonApiClient.getPokemonByName(listOfCandidates.get(randomIndex));
    }

    /*private PokeDTO getPokemonByMostWantedPlaceToVisit(String mostWantedPlaceToVisit) {

        return pokemonApiClient.getPokemonByName();
    }*/

}
