package com.practice;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * @author kavin Daily review for the daily practice last day.
 */

public class ReviewDailyPractice {
	// LeetCode 135 Candy
	private static int getMinCandies(int[] r) {
		int minNum = 0;
		int[] h = new int[r.length];
		Arrays.fill(h, 1);
		for (int i = 1; i < r.length; ++i) {
			h[i] = r[i] > r[i - 1] ? h[i - 1] + 1 : h[i];
		}
		for (int i = r.length - 2; i >= 0; --i) {
			h[i] = Math.max(h[i], r[i] > r[i + 1] ? r[i + 1] + 1 : h[i]);
		}
		for (int i : h) {
			minNum += i;
		}
		return minNum;
	}

	// Inplace merge sort
	/**
	 * Reverse the positions of the values in the array.
	 * 
	 * @param v
	 * @param l
	 * @param r
	 */
	private static void reverse(int[] v, int l, int r) {
		while (l < r) {
			v[l] += v[r];
			v[r] = v[l] - v[r];
			v[l] = v[l] - v[r];
			l++;
			r--;
		}
	}

	/**
	 * Do reverse to realize the in-place merge of two sorted arrays.
	 * 
	 * @param v
	 * @param pos
	 * @param len
	 * @param nextLen
	 */
	private static void swapBlocks(int[] v, int pos, int len, int nextLen) {
		reverse(v, pos, pos + len - 1);
		reverse(v, pos + len, pos + len + nextLen - 1);
		reverse(v, pos, pos + len + nextLen - 1);
	}

	/**
	 * Given two sorted arrays, find the blocks which should be adjacent in the
	 * right order.
	 * 
	 * @param v
	 * @param l
	 * @param mid
	 * @param r
	 */
	private static void inplaceMergeSort(int[] v, int l, int mid, int r) {
		int i = l;
		int j = mid + 1;
		int index = 0;
		while (i < j && j <= r) {
			while (i < j && v[i] <= v[j]) {
				i++;
			}
			index = j;
			while (j <= r && v[j] <= v[i]) {
				j++;
			}
			swapBlocks(v, i, index - i, j - index);
			i += j - index;
		}
	}

	/**
	 * Merge the array recursively, from the bottom to the top.
	 * 
	 * @param v
	 * @param l
	 * @param r
	 */
	private static void mergeSort(int[] v, int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			mergeSort(v, l, mid);
			mergeSort(v, mid + 1, r);
			inplaceMergeSort(v, l, mid, r);
		}
	}

	// Find Largest Rectangle in Histogram (LeetCode 84)
	private static int getMaxArea(int[] a) {
		int maxArea = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int[] h = new int[a.length + 1];
		h = Arrays.copyOf(a, a.length + 1);
		int i = 0;
		while (i < h.length) {
			if (stack.isEmpty() || h[i] >= h[stack.peek()]) {
				stack.push(i++);
			} else {
				int p = stack.pop();
				maxArea = Math.max(maxArea, h[p] * (stack.isEmpty() ? i : i - stack.peek() - 1));
			}
		}
		return maxArea;
	}

	
	public static void main(String[] args) {
		int[] r = { 4, 3, 2, 1, 1, 2, 3, 1 };

		// Candy
		int candies = getMinCandies(r);
		System.out.println(candies);

		// Inpalce MergeSort
		mergeSort(r, 0, r.length - 1);
		for (int i : r) {
			System.out.print(i + " ");
		}
		System.out.println();

		// Largest Rectangle in Histogram
		int largestRectangleInHistogram = getMaxArea(r);
		System.out.println(largestRectangleInHistogram);
		
		//PalindromePartitioningII
		

	}
}
