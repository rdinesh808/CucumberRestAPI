package com.utils;

import java.io.*;
import java.util.*;

public class DataLibrary {

	public static Object[][] ReadTestData(String JsonFile) throws IOException {
		Map<String, String> EnvironmentValues = new LinkedHashMap<String, String>();
		EnvironmentValues = new JsonCreation().EnvironmentValues(JsonFile);
		return new Object[][]{{EnvironmentValues.toString()}};
	}
}
