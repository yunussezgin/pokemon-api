package com.yunus.pokemonapi.service;

import java.util.List;

import com.querydsl.core.types.Predicate;
import com.yunus.pokemonapi.entity.Pokemon;

public interface PokemonService {

	List<Pokemon> listPokemon(Integer page, Integer size, Predicate predicate);

}
