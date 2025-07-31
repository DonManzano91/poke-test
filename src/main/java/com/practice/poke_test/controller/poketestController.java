package com.practice.poke_test.controller;

import com.practice.poke_test.model.PokeDTO;
import com.practice.poke_test.model.TestValuesDTO;
import com.practice.poke_test.service.PokeTestService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class poketestController {

    private final PokeTestService pokeTestService;

    /**
     * Endpoint to get a list of Pokemon based on the provided TestValues.
     * Practice project to better handle api responses and retrieve data from a service.
     *
     * @param testValuesDTO the input values for generating the dream team
     * @return ResponseEntity containing a list of PokeDTO or bad request if input is invalid
     */
    @PostMapping("/poketest")
    private ResponseEntity<List<PokeDTO>> getPokeTest(@RequestBody TestValuesDTO testValuesDTO) {
        try {
            if (testValuesDTO == null ) {
                return ResponseEntity.badRequest().body(null);
            }
            List<PokeDTO> pokeList = pokeTestService.getDreamTeam(testValuesDTO);
            return ResponseEntity.ok(pokeList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
