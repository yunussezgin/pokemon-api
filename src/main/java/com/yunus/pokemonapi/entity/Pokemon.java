package com.yunus.pokemonapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pokemon {

	@Id
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

}
