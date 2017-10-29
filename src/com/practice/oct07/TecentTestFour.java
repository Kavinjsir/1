package com.practice.oct07;

import java.util.Scanner;

public class TecentTestFour {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		int left = -90;
		int right = 90;
		
		for(int i = 0; i < 6; ++i) {
			if(n < (left + right) / 2) {
				sb.append('0');
				right = (left + right) / 2;
			}
			else {
				sb.append('1');
				left = (left + right) / 2;
			}
		}
		
		String str = sb.toString();
		System.out.println(str);
		
	}
}
