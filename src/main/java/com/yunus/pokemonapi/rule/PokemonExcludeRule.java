package com.yunus.pokemonapi.rule;

import com.yunus.pokemonapi.dto.PokemonDto;
import com.yunus.pokemonapi.util.Constants;

public class PokemonExcludeRule implements BaseRule {

	@Override
	public boolean run(PokemonDto dto) {

		if (dto.isLegendary()) {
			return false;
		}

		if (Constants.POKEMON_TYPE_GHOST.equals(dto.getType1())
				|| Constants.POKEMON_TYPE_GHOST.equals(dto.getType2())) {
			return false;
		}

		return true;
	}

}
