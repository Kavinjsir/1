package com.practice.oct21;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1TwoSum {
	private static int[] getTwo(int[] a, int s) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; map.put(a[i], i++)) {
			if (map.containsKey(s - a[i])) {
				return new int[] { map.get(s - a[i]), i };
			}
		}
		return new int[] { 0, 0 };
	}

	public static void main(String[] args) {
		int[] a = { 3, 2, 4 };
		int s = 6;
		int[] res = getTwo(a, s);
		System.out.println(res[0] + " " + res[1]);
	}
}
