package com.yunus.pokemonapi.util;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error {

	@JsonProperty("code")
	private String code = null;

	@JsonProperty("message")
	private String message = null;

}
