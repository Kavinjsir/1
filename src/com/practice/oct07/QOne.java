package com.practice.oct07;

import java.util.Scanner;

public class QOne {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		switch (str.length()) {
		case 1:{
			int pos = 0;
			pos += (str.charAt(0) - 'a') * 16276;
			System.out.println(pos);
			break;
		}
		case 2:{
			int pos = 0;
			pos += ((str.charAt(0) - 'a') * 16276 + 
					(str.charAt(1) - 'a') * 651 + 1);
			System.out.println(pos);
			break;
		}
		case 3:{
			int pos = 0;
			pos += ((str.charAt(0) - 'a') * 16276 + 
					(str.charAt(1) - 'a') * 651 + 1 + 
					(str.charAt(2) - 'a') * 26 + 1);
			System.out.println(pos);
			break;
		}
		case 4:{
			int pos = 0;
			pos += ((str.charAt(0) - 'a') * 16276 + 
					(str.charAt(1) - 'a') * 651 + 1 + 
					(str.charAt(2) - 'a') * 26 + 1 + 
					(str.charAt(3) - 'a') + 1);
			System.out.println(pos);
			break;
		}
		default:
			System.out.println("Bad input. Out of Range!");
			break;
		}
	}
}
