package com.practice.oct28;

public class SelectionSort {
	private static void selectionSort(int[] nums) {
		for (int i = 0; i < nums.length - 1; ++i) {
			int v = i;
			for (int j = i + 1; j < nums.length; ++j) {
				if (nums[j] < nums[v]) {
					v = j;
				}
			}
			if (v != i) {
				nums[v] = nums[i] + nums[v];
				nums[i] = nums[v] - nums[i];
				nums[v] = nums[v] - nums[i];
			}
			
		}
	}

	public static void main(String[] args) {
		int[] nums = { 9, 2, 4, 5, 1, 3 };
		selectionSort(nums);
		for (int i : nums) {
			System.out.println(i);
		}
	}
}
