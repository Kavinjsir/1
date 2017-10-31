package com.practice.oct31;

import java.lang.reflect.InvocationTargetException;

public class InsertionSort {

	private InsertionSort() {
	}

	public static <T extends Comparable<T>> void sort(T[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; ++i) {
			T v = arr[i];
			int j = i;
			for (; j > 0 && arr[j - 1].compareTo(v) < 0; --j) {
				arr[j] = arr[j - 1];
			}
			arr[j] = v;
		}
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		int N = 10000;
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10000);
		SortTestHelper.testSort("com.practice.oct31.InsertionSort", arr);
	}

}
