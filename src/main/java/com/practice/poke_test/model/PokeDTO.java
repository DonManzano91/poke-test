package com.practice.poke_test.model;

import lombok.Data;

@Data
public class PokeDTO {

    private String name;
    private String type;
    private int hp;
    private int attack;
    private int defense;
    private String description;
    private String imageUrl;

}
