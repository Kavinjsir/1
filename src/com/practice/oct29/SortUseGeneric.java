package com.practice.oct29;

import java.lang.reflect.InvocationTargetException;

public class SortUseGeneric {

	// Selection Sort
	public static <T extends Comparable<T>> void selectionSort(T a[]) {
		int len = a.length - 1;
		for (int i = 0; i < len; ++i) {
			int v = i;
			for (int j = i + 1; j <= len; ++j) {
				if (a[j].compareTo(a[v]) < 0) {
					v = j;
				}
			}
			if (v != i) {
				T t = a[v];
				a[v] = a[i];
				a[i] = t;
			}
		}
	}

	// Insertion Sort
	public static <T extends Comparable<T>> void insertionSort(T a[]) {
		int len = a.length;
		for (int i = 1; i < len; ++i) {
			T val = a[i];
			int j;
			for (j = i; j > 0 && a[j - 1].compareTo(a[i]) > 0; --j) {
				a[j] = a[j - 1];
			}
			a[j] = val;
		}
	}

	// Bubble Sort
	public static <T extends Comparable<T>> void bubbleSort(T a[]) {
		boolean swapped;
		int len = a.length;
		do {
			swapped = false;
			for (int i = 1; i < len; ++i) {
				if (a[i].compareTo(a[i - 1]) < 0) {
					T tmp = a[i];
					a[i] = a[i - 1];
					a[i - 1] = tmp;
					swapped = true;
				}
			}
		} while (swapped);
	}

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		// Test the Generic function
		/*
		 * // Integer[] a = { 9, 2, 4, 5, 1, 3 }; String[] a = { "ebiuvn", "qeoirnv",
		 * "qeovip", "d;sonv", "df;a", "zxc" }; selectionSort(a); for (String i : a) {
		 * System.out.println(i); }
		 */

		/**
		 * Generate random array for test. Implement test methods to check the
		 * correctness and count the time consumed.
		 */
		Integer[] arr = SortTestHelper.generateRandomArray(10000);

		Integer[] atest = arr.clone();
		Integer[] btest = arr.clone();
		Integer[] ctest = arr.clone();

		SortTestHelper.testSort("selectionSort", atest);
		SortTestHelper.testSort("insertionSort", btest);
		SortTestHelper.testSort("bubbleSort", ctest);

	}
}
