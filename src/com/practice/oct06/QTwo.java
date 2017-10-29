package com.practice.oct06;

import java.util.Scanner;

/**
 * 
 * @author kavin
 * https://www.nowcoder.com/profile/8470006/test/11639934/44803#summary
 */
public class QTwo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String str = sc.next();
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			
			for(int i = 0; i < str.length(); ++i) {
				if(str.charAt(i) >= 'a') {
					sb1.append(str.charAt(i));
				}
				else {
					sb2.append(str.charAt(i));
				}
			}
			
			String res = sb1.toString() + sb2.toString();
			System.out.println(res);
		}
	}
}
