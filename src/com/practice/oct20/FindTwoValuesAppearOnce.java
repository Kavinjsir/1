package com.practice.oct20;

public class FindTwoValuesAppearOnce {
	private static int[] findTwoValuesAppearOnce(int[] a, int v1, int v2) {
		int getXor = 0;
		for (int i : a) {
			getXor ^= i;
		}

		int getSplit = 1;
		int move = 0;
		while ((getSplit & getXor) == 0) {
			getSplit = (getSplit << 1);
			move++;
		}

		for (int i : a) {
			if (((i >>> move) & 1) == 1) {
				v1 ^= i;
			} else {
				v2 ^= i;
			}
		}
		int[] res = new int[2];
		res[0] = v1;
		res[1] = v2;
		return res;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 1, 2, 3, 4, 8, 16 };
		int v1 = 0;
		int v2 = 0;
		int[] res = new int[2];
		res = findTwoValuesAppearOnce(a, v1, v2);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}
}
