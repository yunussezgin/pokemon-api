package com.yunus.pokemonapi.rule;

import com.yunus.pokemonapi.dto.PokemonDto;

public interface BaseRule {

	boolean run(PokemonDto dto);

}
