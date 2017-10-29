package com.practice.oct16;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * @author kavin
 * @question: https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 *            Given n non-negative integers representing the histogram's bar
 *            height where the width of each bar is 1, find the area of largest
 *            rectangle in the histogram.
 */
public class LeetCode84LargestRectangleInHistogram {
	private static int largestRectangleArea(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int maxArea = 0;
		int[] h = new int[height.length + 1];
		h = Arrays.copyOf(height, height.length + 1);
		while (i < h.length) {
			if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
				stack.push(i++);
			} else {
				int t = stack.pop();
				maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int[] h = { 2, 1, 5, 6, 2, 3 };
		int res = largestRectangleArea(h);
		System.out.println(res);
	}
}
