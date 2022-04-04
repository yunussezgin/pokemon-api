package com.yunus.pokemonapi.repository;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import com.yunus.pokemonapi.entity.Pokemon;
import com.yunus.pokemonapi.entity.QPokemon;

@Repository
public interface PokemonRepository
		extends CrudRepository<Pokemon, Long>, QuerydslPredicateExecutor<Pokemon>, QuerydslBinderCustomizer<QPokemon> {

	@Override
	default void customize(QuerydslBindings bindings, QPokemon pokemon) {
		bindings.bind(String.class)
				.first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);

		bindings.bind(pokemon.hp).all((path, value) -> {
			Iterator<? extends Float> it = value.iterator();
			Float paramValue = it.next();
			return Optional.of(path.goe(paramValue));
		});

		bindings.bind(pokemon.defense).all((path, value) -> {
			Iterator<? extends Float> it = value.iterator();
			Float paramValue = it.next();
			return Optional.of(path.loe(paramValue));
		});

		bindings.bind(pokemon.attack).all((path, value) -> {
			Iterator<? extends Float> it = value.iterator();
			Float paramValue = it.next();
			return Optional.of(path.loe(paramValue));
		});

	}

}
