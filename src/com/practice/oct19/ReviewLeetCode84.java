package com.practice.oct19;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * @author kavin Review LeetCode 84 which has been learned on Oct. 16th
 */

public class ReviewLeetCode84 {
	private static int getMaxArea(int[] height) {
		int maxArea = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int[] h = new int[height.length + 1];
		h = Arrays.copyOf(height, h.length + 1);
		int i = 0;
		while (i < h.length) {
			if (stack.isEmpty() || h[i] >= h[stack.peek()]) {
				stack.push(i++);
			} else {
				int temp = stack.pop();
				maxArea = Math.max(maxArea, h[temp] * (stack.isEmpty() ? i : i - stack.peek() - 1));
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int[] height = {1, 3, 5, 2, 4, 2};
		int maxArea = getMaxArea(height);
		System.out.println(maxArea);
	}
}
