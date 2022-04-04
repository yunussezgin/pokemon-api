package com.yunus.pokemonapi.parser;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.yunus.pokemonapi.dto.PokemonDto;
import com.yunus.pokemonapi.rule.BaseRule;
import com.yunus.pokemonapi.rule.PokemonExcludeRule;
import com.yunus.pokemonapi.rule.PokemonNameRule;
import com.yunus.pokemonapi.rule.PokemonTypeRule;
import com.yunus.pokemonapi.rule.RuleManager;
import com.yunus.pokemonapi.util.CommonUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PokemonDataParser {

	private RuleManager ruleManager;

	public PokemonDataParser(RuleManager ruleManager) {
		this.ruleManager = ruleManager;
		ruleManager.addRule(new PokemonExcludeRule());
		ruleManager.addRule(new PokemonTypeRule());
		ruleManager.addRule(new PokemonNameRule());
	}

	public List<PokemonDto> parseDataFromFile(String fileName) {
		List<PokemonDto> pokemonList = new ArrayList<>();
		InputStreamReader streamReader = CommonUtils.prepareFileReader(fileName);

		try (CSVReader csvReader = new CSVReader(streamReader)) {
			String[] values = csvReader.readNext();

			while ((values = csvReader.readNext()) != null) {
				PokemonDto pokemon = new PokemonDto();
				pokemon.setId(Long.valueOf(values[0]));
				pokemon.setName(values[1]);
				pokemon.setType1(values[2]);
				pokemon.setType2(values[3]);
				pokemon.setTotal(Float.valueOf(values[4]));
				pokemon.setHp(Float.valueOf(values[5]));
				pokemon.setAttack(Float.valueOf(values[6]));
				pokemon.setDefense(Float.valueOf(values[7]));
				pokemon.setSpecialAttack(Float.valueOf(values[8]));
				pokemon.setSpecialDefense(Float.valueOf(values[9]));
				pokemon.setSpeed(Float.valueOf(values[10]));
				pokemon.setGeneration(Integer.valueOf(values[11]));
				pokemon.setLegendary(Boolean.valueOf(values[12]));

				List<BaseRule> ruleList = ruleManager.getRuleList();
				boolean addPokemon = true;

				for (BaseRule rule : ruleList) {
					if (!rule.run(pokemon)) {
						addPokemon = false;
						break;
					}
				}

				if (addPokemon) {
					pokemonList.add(pokemon);
				}
			}

		} catch (Exception ex) {
			log.error("Pokemon.parseDataFromFile exception occured! message:{}", ex.getMessage(), ex);
		}

		return pokemonList;
	}

}
