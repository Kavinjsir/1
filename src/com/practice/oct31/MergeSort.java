package com.practice.oct31;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import com.practice.oct31.SortTestHelper;

public class MergeSort {

	private MergeSort() {
	}

	public static <T extends Comparable<T>> void insertionSortforThis(T a[], int l, int r) {
		for (int i = l + 1; i <= r; ++i) {
			T val = a[i];
			int j;
			for (j = i; j > l && a[j - 1].compareTo(val) > 0; --j) {
				a[j] = a[j - 1];
			}
			a[j] = val;
		}
	}

	public static <T extends Comparable<T>> void merge(T[] a, int l, int mid, int r) {
		T[] c = Arrays.copyOfRange(a, l, r + 1);
		int i = l, j = mid + 1;

		for (int k = l; k <= r; ++k) {
			if (i > mid) {
				a[k] = c[j - l];
				j++;
			} else if (j > r) {
				a[k] = c[i - l];
				i++;
			} else if (c[i - l].compareTo(c[j - l]) < 0) {
				a[k] = c[i - l];
				i++;
			} else {
				a[k] = c[j - l];
				j++;
			}
		}
	}

	public static <T extends Comparable<T>> void mergeSort(T[] a, int l, int r) {
		if (r - l <= 15) {
			insertionSortforThis(a, l, r);
			return;
		}

		int mid = (l + r) / 2;
		mergeSort(a, l, mid);
		mergeSort(a, mid + 1, r);
		if (a[mid].compareTo(a[mid + 1]) > 0) {
			merge(a, l, mid, r);
		}

	}

	public static <T extends Comparable<T>> void sort(T[] a) {

		int n = a.length - 1;
		mergeSort(a, 0, n);
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		// Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
		// 可以在1秒之内轻松处理100万数量级的数据
		// 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
		// 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
		int N = 1000000;
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
		SortTestHelper.testSort("com.practice.oct31.MergeSort", arr);

		return;
	}
}
