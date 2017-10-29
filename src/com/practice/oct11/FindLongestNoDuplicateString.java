package com.practice.oct11;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 
 * @author kavin
 * Question:
 * Find the longest sub-string with no duplicate values.
 */

public class FindLongestNoDuplicateString {
	private static int getLength(String str, Map<Character, Integer> map) {
		int res = 0;
		int count = 1;
		int i = 0;
		map.put(str.charAt(i), 1);
		
		while(i < str.length() - 1) {
			for(int j = i + 1; j < str.length(); ++j) {
				if(!map.containsKey(str.charAt(j))) {
					count++;
					map.put(str.charAt(j), 1);
					continue;
				}
				else {
					map.clear();
					map.put(str.charAt(j), 1);
					i = j;
					if(count > res) {
						res = count;
					}
					count = 1;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        String str = sc.next();
		Map<Character, Integer> map = new TreeMap<Character, Integer>();
		int res = getLength(str, map);
		System.out.println(res);
	}
}
