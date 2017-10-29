package com.practice.oct06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 
 * @author kavin
 * https://www.nowcoder.com/profile/8470006/test/11639934/44804#summary
 * Key Points:
 * Map< , >, List< >, ArrayList< >, 
 */

public class QThree {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();//Number of values
			int[] data = new int[n];
			for(int i = 0; i < n; ++i) {
				data[i] = sc.nextInt();
			}
			
			//Sort data
			Arrays.sort(data);
			
			//Get numbers of each value and store them in a map
			Map<Integer, Integer> cabin = new TreeMap<Integer, Integer>();
			for(int element : data) {
				if(cabin.containsKey(element)) {
					cabin.put(element, cabin.get(element) + 1);
				}
				else {
					cabin.put(element, 1);
				}
			}
			
			//Get minimal distance count
			int minCount = 0;
			if(cabin.size() == n) {//In case each value in data is unique.
				int min = data[1] - data[0];
				minCount = 1;
				int temp;
				for(int i = 2; i < data.length; ++i) {
					temp = data[i] - data[i-1];
					if(temp == min) {
						minCount++;
					}
					else if(temp < min) {
						min = temp;
						minCount = 1;
					}
				}
			}
			else {
				int temp;
				for(Integer key : cabin.keySet()) {
					temp = cabin.get(key);
					if(temp > 1) {
						minCount += temp * (temp - 1) / 2;
					}
				}
			}
			
			//Get maximal distance count
			int maxCount = 0;
			List<Integer> keyArray = new ArrayList<Integer>(cabin.keySet());
			maxCount = cabin.get(keyArray.get(0)) * cabin.get(keyArray.get(keyArray.size() - 1));
			
			System.out.println(minCount + " " + maxCount);
		}
	}
}
