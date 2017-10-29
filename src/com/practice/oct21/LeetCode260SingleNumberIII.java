package com.practice.oct21;

public class LeetCode260SingleNumberIII {
	private static int[] getTwo(int[] a) {
		int[] res = new int[2];

		int fir = 0;
		for (int i : a) {
			fir ^= i;
		}

		int move = 0;
		while (((fir >>> move) & 1) != 1) {
			move++;
		}

		int v1 = 0;
		int v2 = 0;
		for (int i : a) {
			if (((i >>> move) & 1) == 1) {
				v1 ^= i;
			} else {
				v2 ^= i;
			}
		}
		res[0] = v1;
		res[1] = v2;
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 1, 2, 3, 4, 6, 6, 7, 7 };
		int[] res = getTwo(nums);
		for (int i : res) {
			System.out.println(i);
		}
	}
}
