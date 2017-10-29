package com.practice.oct19;

import java.util.Arrays;

public class LeetCode135Candy {
	public static int candy(int[] ratings) {
		int candies[] = new int[ratings.length];
		Arrays.fill(candies, 1);
		for (int i = 1; i < candies.length; ++i) {
			candies[i] = ratings[i] > ratings[i - 1] ? candies[i - 1] + 1 : candies[i];
		}
		for (int i = candies.length - 2; i >= 0; --i) {
			candies[i] = ratings[i] > ratings[i + 1] ? Math.max(candies[i], candies[i + 1] + 1) : candies[i];
		}
		int sum = 0;
		for (Integer i : candies) {
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] r = {4, 3, 2, 1, 2, 3, 1};
		int res = candy(r);
		System.out.println(res);
	}
}
