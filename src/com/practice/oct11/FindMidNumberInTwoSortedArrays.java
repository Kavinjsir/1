package com.practice.oct11;

/**
 * 
 * @author kavin
 * @Question
 * Give two sorted arrays, find the mid value of the array merged by the two.
 */

public class FindMidNumberInTwoSortedArrays {
	public static double midValue(int[] arr1, int front1, int end1, int[] arr2, int front2, int end2) {
		if((end1 == front1) && (end2 == front2)) {
			return (arr1[front1] + arr2[front2]) / 2.0;
		}
		
		double midOne = ((front1 + end1) % 2 == 0) ? arr1[(front1 + end1)/2] * 1.0 : (arr1[(front1 + end1)/2] + arr1[(front1 + end1)/2 + 1]) / 2.0;
		double midTwo = ((front2 + end2) % 2 == 0) ? arr2[(front2 + end2)/2] * 1.0 : (arr2[(front2 + end2)/2] + arr2[(front2 + end2)/2 + 1]) / 2.0;
		
	    if(midOne == midTwo) {
	    	    return midOne;
	    }
	    else if(midOne < midTwo) {
	    	    int pos = ((front1 + end1) % 2 == 0) ? (front1 + end1) / 2 : (front1 + end1) / 2 + 1;
	    	    end2 = end2 - (pos - front1); 
	    	    return midValue(arr1, pos, end1, arr2, front2, end2);
	    }
	    else {
	        int pos = ((front2 + end2) % 2 == 0) ? (front2 + end2) / 2 : (front2 + end2) / 2 + 1;
	        end1 = end1 - (pos - front2);
	        return midValue(arr1, front1, end1, arr2, pos, end2);
	    }
	}

	public static void main(String[] argc) {
		int[] arr1 = {0,5,12,14,17,18,18};
		int[] arr2 = {1,27,34,34,45,46,48};
		System.out.println(midValue(arr1, 0, arr1.length - 1, arr2, 0, arr2.length - 1));
	}
}