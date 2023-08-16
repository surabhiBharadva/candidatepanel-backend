package com.example.candidatepanelbackend.utils;

public final class FirstLetterCapital {
	private FirstLetterCapital(){}
	public static String capitalize(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

}
