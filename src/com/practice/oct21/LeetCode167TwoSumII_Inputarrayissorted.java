package com.practice.oct21;

public class LeetCode167TwoSumII_Inputarrayissorted {
	private static int[] twoSum(int[] numbers, int target) {
		int i = 0, j = numbers.length - 1;
		while (numbers[i] + numbers[j] != target) {
			if (numbers[i] + numbers[j] > target) {
				j--;
			} else {
				i++;
			}
		}
		return new int[] { ++i, ++j };
	}

	public static void main(String[] args) {
		int[] numbers = { 1, 3, 6, 9, 13, 16, 19, 23, 25 };
		int target = 32;
		int[] res = twoSum(numbers, target);
		System.out.println(res[0] + " " + res[1]);
	}
}
