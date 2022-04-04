package com.yunus.pokemonapi.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.yunus.pokemonapi.entity.Pokemon;
import com.yunus.pokemonapi.service.PokemonService;

@WebMvcTest
public class PokemonControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PokemonService pokemonService;

	Pokemon pokemonMock = null;
	List<Pokemon> pokemonListMock = null;

	@BeforeEach
	public void setup() {
		pokemonListMock = new ArrayList<>();

		pokemonMock = new Pokemon();
		pokemonMock.setId(1L);
		pokemonMock.setName("Bulbasaur");
		pokemonMock.setAttack(100);
		pokemonMock.setDefense(50);
		pokemonMock.setGeneration(1);
		pokemonMock.setHp(20);
		pokemonMock.setLegendary(false);
		pokemonMock.setSpecialAttack(50);
		pokemonMock.setSpecialDefense(30);
		pokemonMock.setSpeed(100);
		pokemonMock.setTotal(200);
		pokemonMock.setType1("Grass");
		pokemonMock.setType2("Poison");

		pokemonListMock.add(pokemonMock);

		pokemonMock = new Pokemon();
		pokemonMock.setId(2L);
		pokemonMock.setName("Clawitzer");
		pokemonMock.setAttack(100);
		pokemonMock.setDefense(50);
		pokemonMock.setGeneration(1);
		pokemonMock.setHp(20);
		pokemonMock.setLegendary(false);
		pokemonMock.setSpecialAttack(50);
		pokemonMock.setSpecialDefense(30);
		pokemonMock.setSpeed(100);
		pokemonMock.setTotal(200);
		pokemonMock.setType1("Rock");
		pokemonMock.setType2("Dragon");

		pokemonListMock.add(pokemonMock);

	}

	@Test
	public void givenPokemonList_whenListPokemons_thenReturnPokemonList() throws Exception {
		// given
		given(pokemonService.listPokemon(any(), any(), any())).willReturn(pokemonListMock);

		// when
		ResultActions response = mockMvc.perform(get("/pokemon"));

		// then
		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.size()", is(pokemonListMock.size())));
	}

}
