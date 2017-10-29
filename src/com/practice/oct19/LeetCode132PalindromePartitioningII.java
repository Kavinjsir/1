package com.practice.oct19;

public class LeetCode132PalindromePartitioningII {
	private static int cutTimes(String str) {
		int[] dp = new int[str.length() + 1];
		dp[0] = -1;
		for (int i = 1; i <= str.length(); ++i) {
			dp[i] = i - 1;
			for (int j = 0; j <= i - 1; ++j) {
				StringBuilder sb = new StringBuilder();
				for(int k = j; k <= i - j && k < str.length(); ++k) {
					sb.append(str.charAt(k));
				}
				String s = sb.toString();
				String ss = sb.reverse().toString();
				if (s.equals(ss)) {
					dp[i] = Math.min(dp[i], dp[j] + 1);
				}
			}
		}
		return dp[str.length() - 1];
	}

	public static void main(String[] args) {
		String str = "bababa";
		int res = cutTimes(str);
		System.out.println(res);
	}
}
