package com.yunus.pokemonapi.rule;

import com.yunus.pokemonapi.dto.PokemonDto;
import com.yunus.pokemonapi.util.Constants;

public class PokemonTypeRule implements BaseRule {

	@Override
	public boolean run(PokemonDto dto) {

		if (Constants.POKEMON_TYPE_STEAL.equals(dto.getType1())
				|| Constants.POKEMON_TYPE_STEAL.equals(dto.getType2())) {
			dto.setHp(dto.getHp() * 2);
		}

		if (Constants.POKEMON_TYPE_FIRE.equals(dto.getType1()) || Constants.POKEMON_TYPE_FIRE.equals(dto.getType2())) {
			dto.setAttack(dto.getAttack() * 0.9f);
		}

		if ((Constants.POKEMON_TYPE_BUG.equals(dto.getType1()) && Constants.POKEMON_TYPE_FLYING.equals(dto.getType2()))
				|| (Constants.POKEMON_TYPE_BUG.equals(dto.getType2())
						&& Constants.POKEMON_TYPE_FLYING.equals(dto.getType1()))) {
			dto.setAttack(dto.getAttack() * 1.1f);
		}

		return true;
	}

}
