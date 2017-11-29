package com.practice.nov28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeWatchingFirst {

	static int size;
	static char[] arrChar;

	public static void main(String[] args) throws IOException {
		System.out.print("Enter a word: ");
		String input = getString();
		size = input.length();
		arrChar = new char[size];
		for (int j = 0; j < size; j++)
			arrChar[j] = input.charAt(j);
		doAnagram(size);
	}

	public static void doAnagram(int newSize) {
		if (newSize == 1)
			return;
		for (int i = 0; i < newSize; ++i) {
			doAnagram(newSize - 1);
			if (newSize == 2)
				displayWord();
			rotate(newSize);
		}
	}

	public static void rotate(int newSize) {
		int positon = size - newSize;
		char temp = arrChar[positon];
		int j;
		for (j = positon + 1; j < size; ++j)
			arrChar[j - 1] = arrChar[j];
		arrChar[j - 1] = temp;
	}

	public static void displayWord() {

		for (int j = 0; j < size; j++)
			System.out.print(arrChar[j]);
		System.out.println("   ");
		System.out.flush();

	}

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

}
