package com.grupo01.spring.utils;

import java.util.UUID;

public class Random {
	
	public static String getRandom() {
		final String random = UUID.randomUUID().toString();
		return random.replace("-", "");
	}

}
