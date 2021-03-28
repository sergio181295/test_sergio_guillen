package com.guillen.entity.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Utils {

	public static String getStringFromMap(Map<String, Object> map, String key) {
		Object value = map.get(key);
		if (value != null) {
			return value.toString();
		}
		return null;
	}

	public static Double getDoubleFromMap(Map<String, Object> map, String key) {
		Object value = map.get(key);
		if (value != null) {
			return (Double) value;
		}
		return null;
	}

	public static List<?> getListoFromMap(Map<String, Object> map, String key) {
		Object value = map.get(key);
		List<?> list = new ArrayList<>();
		if (value.getClass().isArray()) {
			list = Arrays.asList((Object[]) value);
		} else if (value instanceof Collection) {
			list = new ArrayList<>((Collection<?>) value);
		}
		return list;
	}
}
