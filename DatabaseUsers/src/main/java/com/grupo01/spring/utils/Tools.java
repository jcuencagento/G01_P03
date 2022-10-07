package com.grupo01.spring.utils;

import java.util.UUID;

public class Tools {
	
	//String aleatorio (1_a parte de token)
	public static String getRandomNumberString() {
		final String randomString = UUID.randomUUID().toString(); // de tipo  00704603-2853-4a05-be72-c9963475f538
		System.out.println("---------- "+randomString);
		//Y lo voy a enviar sin guiones... simulando un número grande
		return randomString.replace("-", ""); // String sin guiones

	}

}
