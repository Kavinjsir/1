package com.practice.oct20;

public class ReverseString {
	private static String reverseString(String str) {
		if(str.length() == 1) {
			return str;
		}
		return reverseString(str.substring(1)) + str.charAt(0);
	}
	
	public static void main(String[] args) {
		String str = "abcde";
		System.out.println(reverseString(str));
	}
	
}
