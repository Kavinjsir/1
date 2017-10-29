package com.practice.oct07;

import java.util.Scanner;

public class TecentTestThree {
	public static boolean isPrimeNum(int x) {
		if(x <= 1) {
			return false;
		}
		for(int i = 2; i < x/2; ++i) {
			if(x % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		if(isPrimeNum(n - 2)) {
			count++;
		}
		for(int i = 3; i <= n/2; ++i) {
			if(isPrimeNum(i) && isPrimeNum(n - i)) {
				count++;
			}
		}
		System.out.println(count);
	}
}
