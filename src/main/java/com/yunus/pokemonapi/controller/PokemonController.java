package com.yunus.pokemonapi.controller;

import java.util.List;

import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.Predicate;
import com.yunus.pokemonapi.entity.Pokemon;
import com.yunus.pokemonapi.service.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

	private PokemonService pokemonService;

	public PokemonController(PokemonService pokemonService) {
		this.pokemonService = pokemonService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Pokemon>> listPokemon(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size,
			@QuerydslPredicate(root = Pokemon.class) Predicate predicate) {
		List<Pokemon> pokemons = pokemonService.listPokemon(page, size, predicate);
		return new ResponseEntity<>(pokemons, HttpStatus.OK);
	}

}
