package com.practice.poke_test.pokeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum CitiesToRegionEnum {
    KANTO(Arrays.asList("Tokio", "Singapur")),
    JOHTO(Arrays.asList("Osaka", "Seul")),
    HOENN(Arrays.asList("Londres", "Madrid")),
    SINNOH(Arrays.asList("París", "Berlín")),
    UNOVA(Arrays.asList("Nueva York", "Los Ángeles")),
    KALOS(Arrays.asList("Bruselas", "Ámsterdam")),
    ALOLA(Arrays.asList("Honolulu", "Bora Bora")),
    GALAR(Arrays.asList("Edimburgo", "Dublín")),
    PALDEA(Arrays.asList("Barcelona", "Valencia"));

    private final List<String> ciudades;
    //TODO: Define que aca te regresse un aleatorio en el rango de la region deseada
//    public int getPokemonNumberByRegion(String ciudad) {
//        switch ()
//    }

}
