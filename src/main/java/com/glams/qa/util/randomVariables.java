package com.glams.qa.util;

import java.util.Random;

public class randomVariables {

	public static String GlobalVar;
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHI_abcdefghi";

	public static void getRandomVariable() {

		StringBuilder sb = new StringBuilder();

		int min = 3;
		int max = 7;
		Random r = new Random();
		int randomvalue = r.nextInt((max - min) + 1) + min;
		while (randomvalue-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			sb.append(ALPHA_NUMERIC_STRING.charAt(character));

		}
		String generatedValue = sb.toString();
		String RandomValue = "GLAMS_" + String.valueOf(generatedValue);
		System.out.println("Global Variable is : " + RandomValue);
		GlobalVar = RandomValue;

	}

}
