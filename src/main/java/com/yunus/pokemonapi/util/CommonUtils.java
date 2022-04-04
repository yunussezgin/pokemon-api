package com.yunus.pokemonapi.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonUtils {

	public static String getArrayValueWithDefault(String[] array, int index, String defaultValue) {
		return array.length <= index ? defaultValue : array[index];
	}

	public static InputStreamReader prepareFileReader(String fileName) {
		File file = Paths.get("src", "main", "resources", "data", fileName).toFile();
		InputStreamReader reader = null;
		try {
			FileInputStream stream = new FileInputStream(file);
			reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
		} catch (FileNotFoundException e) {
			log.error("CommonUtils.prepareFileReader exception occured! message:{}", e.getMessage(), e);
		}
		return reader;
	}

	public static int getWithDefault(Integer value, Integer defaultValue) {
		return value == null ? defaultValue : value;
	}

}
