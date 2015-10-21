package com.trimc.blogger.commons.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class GsonUtils {

	public static String toJsonFormatted(Object obj) {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
		return gson.toJson(obj);
	}

	public static String toJsonFormattedAll(Object obj) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(obj);
	}

	public static String toJsonSingleLine(Object obj) {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

		String text = gson.toJson(obj);
		text = text.replaceAll(",\"", ", \"");

		return text;
	}

	public static String toJsonSingleLineAll(Object obj) {
		Gson gson = new GsonBuilder().create();

		String text = gson.toJson(obj);
		text = text.replaceAll(",\"", ", \"");

		return text;
	}

	public static <T> T toObject(String json, Class<T> clazz) {
		return new Gson().fromJson(json, clazz);
	}
}
