package com.practice.oct20;

import java.util.ArrayList;
import java.util.List;

public class LeetCode131PalindromePartitioning {
	// Check whether substring is Palindrome
	public static boolean isPal(String s, int low, int high) {
		while (low < high) {
			if (s.charAt(low++) != s.charAt(high--)) {
				return false;
			}
		}
		return true;
	}

	// Once find one Palindrome from the beginning, from the following by DFS.
	public static void dfs(String s, int pos, List<String> list, List<List<String>> res) {
		if (pos == s.length()) {
			res.add(new ArrayList<String>(list));
		} else {
			for (int i = pos; i < s.length(); ++i) {
				if (isPal(s, pos, i)) {
					list.add(s.substring(pos, i + 1));
					dfs(s, i + 1, list, res);
					list.remove(list.size() - 1);
				}
			}
		}
	}

	public static List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		List<String> list = new ArrayList<String>();
		dfs(s, 0, list, res);
		return res;
	}

	public static void main(String[] args) {
		String s = "ababa";
		List<List<String>> res = new ArrayList<List<String>>();
		res = partition(s);
		for (List<String> l : res) {
			for (String str : l) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}
}
