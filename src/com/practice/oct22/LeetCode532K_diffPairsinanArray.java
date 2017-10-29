package com.practice.oct22;

import java.util.HashMap;
import java.util.Map;

public class LeetCode532K_diffPairsinanArray {
	public static int findPairs(int[] nums, int k) {
		int count = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		if (k < 0) {
			return 0;
		} else if (k == 0) {
			for (int i : nums) {
				if (map.containsKey(i)) {
					if (map.get(i) == 0) {
						map.put(i, 1);
						count++;
					}
				} else {
					map.put(i, 0);
				}
			}
		} else {
			for (int i : nums) {
				if (map.containsKey(i)) {
					continue;
				}
				if (map.containsKey(i - k)) {
					map.put(i - k, map.get(i - k) + 1);
				}
				if (map.containsKey(i + k)) {
					map.put(i + k, map.get(i + k) + 1);
				}
				map.put(i, 0);
			}
			for (Integer i : map.keySet()) {
				count += map.get(i);
			}
		}

		for (Integer i : map.keySet()) {
			System.out.println(i + " " + map.get(i));
		}

		return count;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int k = 2;
		int res = findPairs(a, k);
		System.out.println(res);
	}
}
