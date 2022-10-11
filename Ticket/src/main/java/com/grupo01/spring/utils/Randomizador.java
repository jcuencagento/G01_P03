package com.grupo01.spring.utils;

public class Randomizador {
	
	public static int generarNumAleatorio(int numInicial, int numFinal) {
		  return (int) Math.floor(Math.random()*((double)numFinal-(double)numInicial+1)+(double)numInicial);
	}

}
