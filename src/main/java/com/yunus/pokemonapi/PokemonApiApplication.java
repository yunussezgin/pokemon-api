package com.yunus.pokemonapi;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.yunus.pokemonapi.dto.PokemonDto;
import com.yunus.pokemonapi.entity.Pokemon;
import com.yunus.pokemonapi.parser.PokemonDataParser;
import com.yunus.pokemonapi.repository.PokemonRepository;
import com.yunus.pokemonapi.util.Constants;

@SpringBootApplication
@ComponentScan(basePackages = { "com.yunus.*" })
public class PokemonApiApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(PokemonApiApplication.class, args);

		PokemonDataParser pokemonDataParser = applicationContext.getBean(PokemonDataParser.class);
		List<PokemonDto> pokemonDtoList = pokemonDataParser.parseDataFromFile(Constants.POKEMON_FILE_NAME);
		
		PokemonRepository pokemonRepository = applicationContext.getBean(PokemonRepository.class);
		for (PokemonDto dto : pokemonDtoList) {
			Pokemon pokemon = new Pokemon();
			BeanUtils.copyProperties(dto, pokemon);
			pokemonRepository.save(pokemon);
		}
	}

}
