package com.practice.oct16;

/**
 * 
 * @author kavin
 * @question: https://leetcode.com/problems/patching-array/description/
 */

public class LeetCode330PatchingArray {
	private static int minPatches(int[] nums, int n) {
		int cnt = 0;
		int max = 0;
		for (int i = 0; max < n;) {
			if (i >= nums.length || max + 1 < nums[i]) {
				max += (max + 1);
				cnt++;
			} else {
				max += nums[i];
				i++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 3 };
		int n1 = 6;

		int[] nums2 = { 1, 2, 2 };
		int n2 = 5;

		int[] nums3 = { 1, 5, 10 };
		int n3 = 20;

		int cnt1 = minPatches(nums1, n1);
		int cnt2 = minPatches(nums2, n2);
		int cnt3 = minPatches(nums3, n3);

		System.out.println(cnt1);
		System.out.println(cnt2);
		System.out.println(cnt3);
	}
}
