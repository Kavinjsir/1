package com.practice.oct06;

import java.util.Scanner;

/**
 * 
 * @author kavin
 * https://www.nowcoder.com/profile/8470006/test/11639934/44802#summary
 * Key Points:
 * Dynamic Programming
 */

public class QOne {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String str1 = sc.next();
			String str2 = new StringBuilder(str1).reverse().toString();
			int[][] dp = new int[str1.length() + 1][str2.length() + 1];
			dp[0][0] = 0;
			for(int i = 1; i <= str1.length(); ++i) {
				for(int j = 1; j <= str2.length(); ++j) {
					dp[i][j] = str1.charAt(i-1) == str2.charAt(j-1) ? dp[i-1][j-1] + 1 : Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
			int res = str1.length() - dp[str1.length()][str2.length()];
			System.out.println(res);
		}
	}
}
