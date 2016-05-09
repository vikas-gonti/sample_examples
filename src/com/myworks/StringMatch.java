package com.myworks;

public class StringMatch {

	
	public static void main(String[] args) {
		
		System.out.println(validateFileName("CAT","C**"));

	}

	private static boolean validateFileName(String str1, String str2) {
		
		if(str1==null && str2==null)
			return false;
		if(str2.startsWith("*")){
			return str1.contains(str2.substring(1));
			
		}
		else if(str2.contains("*")){
			return (str1.contains(str2.substring(0, str2.indexOf('*'))) && str1.contains(str2.substring(str2.indexOf('*')+1)));
		}
		
		return false;
	}

}
