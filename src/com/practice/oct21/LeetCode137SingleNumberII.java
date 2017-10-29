package com.practice.oct21;

public class LeetCode137SingleNumberII {
	private static int getSingle(int[] a) {
		int ans = 0;
		for (int i = 0; i < 32; ++i) {
			int sum = 0;
			for (int j = 0; j < a.length; ++j) {
				if (((a[j] >>> i) & 1) == 1) {// By reference, here it is >> rather than >>>, reason unknown.
					sum++;
				}
				sum %= 3;
			}
			ans |= (sum << i);
		}
		return ans;
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 3, 2, 3, 2, 1, 1 };
		int res = getSingle(a);
		System.out.println(res);
	}
}
