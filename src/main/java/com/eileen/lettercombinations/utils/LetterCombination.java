package com.eileen.lettercombinations.utils;

import java.io.InputStream;
import java.util.Properties;

public class LetterCombination {
	
	public static Properties properties = new Properties();
	
	static {
		try {
			InputStream is = LetterCombination.class.getClassLoader().getResourceAsStream("digits_letters_mapping.properties");
			properties.load(is);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	

	public static void main(String[] args) {
		System.out.println(properties);
		System.out.println(properties.getProperty("map_2"));
		System.out.println(properties.getProperty("map_0").equals(""));
	}
	
	public String combination(int[] input) {
		if(input.length==1) {
			//input only has one digit.
			int firstDigit = input[0];
			String mappingStr = properties.getProperty("map_"+firstDigit);
			//the digit is not mapping to an empty string.
			if(mappingStr!=null&&mappingStr.trim().length()>0) {
				String[] lettersArray = mappingStr.split(",");
				String result="";
				for(String s:lettersArray) {
					result = result + s + " ";
				}
				return result.trim();
			}else {
				//the digit is mapping to an empty string.
				return "";
			}
		}else if(input.length==2) {
			//input has two digits.
			int firstDigit = input[0];
			String firstMappingStr = properties.getProperty("map_"+firstDigit);
			int secondDigit = input[1];
			String secondMappingStr = properties.getProperty("map_"+secondDigit);
			//the first digit is not mapping to an empty string.
			if(firstMappingStr!=null&&firstMappingStr.trim().length()>0) {
				//the second digit is also not mapping to an empty string.
				if(secondMappingStr!=null&&secondMappingStr.trim().length()>0) {
					String[] firstLettersArray = firstMappingStr.split(",");
					String[] secondLettersArray = secondMappingStr.split(",");
					String result="";
					for(String s1:firstLettersArray) {
						for(String s2:secondLettersArray) {
							result = result + s1 + s2 + " ";
						}
					}
					return result.trim();
				}else {
					//the first digit is not mapping to an empty string.
					//but the second digit is mapping to an empty string.
					String[] lettersArray = firstMappingStr.split(",");
					String result="";
					for(String s:lettersArray) {
						result = result + s + " ";
					}
					return result.trim();
				}
			}else {
				//the first digit is mapping to an empty string.
				//but the second digit is not mapping to an empty string.
				if(secondMappingStr!=null&&secondMappingStr.trim().length()>0) {
					String[] lettersArray = secondMappingStr.split(",");
					String result="";
					for(String s:lettersArray) {
						result = result + s + " ";
					}
					return result.trim();
				}else {
					//both the first digit and the second digit are mapping to an empty string.
					return "";
				}
			}
		}else {
			System.out.println("Invalid input.");
			return "";
		}
	}
}
