package com.yunus.pokemonapi.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.yunus.pokemonapi.util.Error;

import com.yunus.pokemonapi.util.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionHandlingController {

	@ExceptionHandler({ RuntimeException.class, Exception.class })
	public ResponseEntity<Error> otherExceptions(Exception e, HttpServletRequest request,
			HttpServletResponse response) {
		log.error("PokemonAPI exception occured -> RuntimeException: {}",
				e.toString().concat(StringUtils.SPACE).concat(e.getMessage()));

		Error exceptionResponse = generateExceptionResponse(Constants.INTERNAL_SERVER_ERROR_CODE,
				e.toString().concat(StringUtils.SPACE).concat(e.getMessage()));

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
	}

	private Error generateExceptionResponse(String code, String message) {
		Error response = new Error();
		response.setCode(code);
		response.setMessage(message);
		return response;
	}

}
