package kr.pe.gbpark.util.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.gson.JsonParser.parseString;

@Service
public class CommonUtil {
	public static Map<String, Object> convertVoToMap(Object voObject) throws IllegalArgumentException, IllegalAccessException {

		Map<String, Object> result = new HashMap<String, Object>();

		for (Field field : voObject.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			Object value = field.get(voObject);
			if (value != null) {
				result.put(field.getName(), value);
			}
		}

		return result;
	}

	public static JsonObject convertVoToJson(Object VO) throws IllegalArgumentException {
		Gson gson = new Gson();
		return parseString(gson.toJson(VO)).getAsJsonObject();
	}

	public static JsonArray convertVoListToJsonArray(List<?> voList) throws IllegalArgumentException {
		Gson gson = new Gson();
		return parseString(gson.toJson(voList)).getAsJsonArray();
	}
}
