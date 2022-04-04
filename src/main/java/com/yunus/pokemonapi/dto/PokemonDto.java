package com.yunus.pokemonapi.dto;

import lombok.Setter;

import lombok.Getter;

@Getter
@Setter
public class PokemonDto {

	private Long id;
	private String name;
	private String type1;
	private String type2;
	private float total;
	private float hp;
	private float attack;
	private float defense;
	private float specialAttack;
	private float specialDefense;
	private float speed;
	private int generation;
	private boolean legendary;

	@Override
	public String toString() {
		return "PokemonDto [id=" + id + ", name=" + name + ", type1=" + type1 + ", type2=" + type2 + ", total=" + total
				+ ", hp=" + hp + ", attack=" + attack + ", defense=" + defense + ", specialAttack=" + specialAttack
				+ ", specialDefense=" + specialDefense + ", speed=" + speed + ", generation=" + generation
				+ ", legendary=" + legendary + "]";
	}

}
