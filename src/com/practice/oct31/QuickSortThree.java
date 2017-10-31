package com.practice.oct31;

import java.lang.reflect.InvocationTargetException;

public class QuickSortThree {

	// 我们的算法类不允许产生任何实例
	private QuickSortThree() {
	}

	private static <T extends Comparable<T>> void insertionSortforThis(T a[], int l, int r) {
		for (int i = l + 1; i <= r; ++i) {
			T val = a[i];
			int j = i;
			for (; j > l && a[j - 1].compareTo(val) > 0; --j) {
				a[j] = a[j - 1];
			}
			a[j] = val;
		}
	}

	// 递归使用快速排序,对arr[l...r]的范围进行排序
	private static <T extends Comparable<T>> void sort(T[] arr, int l, int r) {
		// 对于小规模数组, 使用插入排序
		if (r - l <= 15) {
			insertionSortforThis(arr, l, r);
			return;
		}

		// 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
		swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

		T v = arr[l];

		int lt = l; // arr[l+1...lt] < v
		int gt = r + 1; // arr[gt...r] > v
		int i = l + 1; // arr[lt+1...i) == v

		while (i < gt) {
			if (arr[i].compareTo(v) < 0) {
				swap(arr, i, lt + 1);
				i++;
				lt++;
			} else if (arr[i].compareTo(v) == 0) {
				i++;
			} else {
				swap(arr, i, --gt);
			}
		}

		swap(arr, l, lt);

		sort(arr, l, lt - 1);
		sort(arr, gt, r);
	}

	public static <T extends Comparable<T>> void sort(T[] arr) {
		int n = arr.length;
		sort(arr, 0, n - 1);
	}

	private static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
		T t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	// 测试 QuickSort3Ways
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		// 三路快速排序算法也是一个O(nlogn)复杂度的算法
		// 可以在1秒之内轻松处理100万数量级的数据
		int N = 1000000;
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
		SortTestHelper.testSort("com.practice.oct31.QuickSortThree", arr);

		return;
	}
}
