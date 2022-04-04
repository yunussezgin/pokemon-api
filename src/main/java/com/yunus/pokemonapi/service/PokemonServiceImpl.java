package com.yunus.pokemonapi.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;
import com.yunus.pokemonapi.entity.Pokemon;
import com.yunus.pokemonapi.repository.PokemonRepository;
import com.yunus.pokemonapi.util.CommonUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PokemonServiceImpl implements PokemonService {

	private PokemonRepository pokemonRepository;

	public PokemonServiceImpl(PokemonRepository pokemonRepository) {
		this.pokemonRepository = pokemonRepository;
	}

	@Override
	public List<Pokemon> listPokemon(Integer page, Integer size, Predicate predicate) {
		log.info("PokemonService -> listPokemon started! page:{} size:{}", page, size);
		List<Pokemon> pokemons = pokemonRepository.findAll(predicate,
				PageRequest.of(CommonUtils.getWithDefault(page, 0), CommonUtils.getWithDefault(size, 100000))).toList();
		log.info("PokemonService -> listPokemon completed!");
		return pokemons;
	}

}
