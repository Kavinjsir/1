package com.practice.oct07;

import java.util.Scanner;
/**
 * 
 * @author kavin
 * Remains problems
 */
public class TecentTestTwo {
	public static void main(String[] args) {
		int[] array = new int[32];
		for(int i = 0; i < 32 ; ++i) {
			array[i] = 0;
		}
		int x, y;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		
		//Do the first input value, set as complete.
		if(x == 1024) {
			array[0] = array[0] | 0x1;
		}
		else {
			int rest = x % 32;
			if(rest == 0) {
				array[x/32] = (array[x/32] | 0x1);
			}
			else {
				array[x/32] = (array[x/32] | (0x1 << rest));
			}
		}

		
		//Do the second input value, find whether complete.    
		if(y == 1024) {
			int res = (array[0] & 1);
			System.out.println(res);
		}
		else if(y >= 1 && y < 1024) {
			int res  = ((array[y/32] & (1 << (x % 32))) >>> (x % 32));
			System.out.println(res);
		}
		else {
			System.out.println(-1);
		}
		
	}
}
