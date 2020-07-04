package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonCreation {
	
	@SuppressWarnings("unchecked")
	public Map<String, String> EnvironmentValues(String Envname) throws IOException {
		Map<String, String> EnvValuesMap = new LinkedHashMap<String, String>();
		Envname=Envname.toUpperCase();
		InputStream file = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			file = new FileInputStream("./Datas/EnvironmentTestData.json");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Map<String, Object> jsonMaps = null;
		try {
			jsonMaps = mapper.readValue(file, new TypeReference<Map<String, Object>>() {});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		EnvValuesMap.putAll((Map<String,String>) jsonMaps.get(Envname));
		return EnvValuesMap;
	}
	public Map<String, Map<String, Object>> readEnvJsonFile(){
		ObjectMapper objectMapper = new ObjectMapper();
		InputStream file = null;
		try {
			file = new FileInputStream("./DataFiles/EnvironmentTestData.json");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Map<String, Map<String, Object>> jsonMaps = null;
		try {
			jsonMaps = objectMapper.readValue(file, new TypeReference<Map<String, Map<String, Object>>>() {
			});

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonMaps;
	}
	public EnvJsonData readEnvJson(String env) throws IOException {
		Map<String, Map<String, Object>> jsonMaps = readEnvJsonFile();
		EnvJsonData passwordReset = new EnvJsonData();
		try {
			passwordReset = new ObjectMapper().readValue(
					new ObjectMapper().writeValueAsString(jsonMaps.get(env)),
					EnvJsonData.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return passwordReset;
	}
	public static void main(String[] args) throws IOException {
		System.out.println(new JsonCreation().readEnvJsonFile());
	}
}