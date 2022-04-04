package com.yunus.pokemonapi.rule;

import com.yunus.pokemonapi.dto.PokemonDto;

public class PokemonNameRule implements BaseRule {

	@Override
	public boolean run(PokemonDto dto) {
		if (dto.getName().startsWith("G")) {
			dto.setDefense(dto.getDefense() + ((dto.getName().length() - 1) * 5));
		}
		return true;
	}

}
