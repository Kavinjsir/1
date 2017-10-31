package com.practice.oct31;

import java.lang.reflect.InvocationTargetException;

public class QuickSort {

	private QuickSort() {
	}

	// 对arr[l...r]部分进行partition操作
	// 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
	private static <T extends Comparable<T>> int partition(T[] arr, int l, int r) {
		
		// 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
		swap( arr, l , (int)(Math.random()*(r-l+1))+l );
		
		T v = arr[l];
		int j = l;
		for (int i = l + 1; i <= r; ++i) {
			if (arr[i].compareTo(v) < 0) {
				j++;
				swap(arr, j, i);
			}
		}
		swap(arr, l, j);
		return j;
	}

	// 递归使用快速排序,对arr[l...r]的范围进行排序
	private static <T extends Comparable<T>> void quickSort(T[] arr, int l, int r) {
		if (l >= r) {
			return;
		}

		int p = partition(arr, l, r);
		quickSort(arr, l, p - 1);
		quickSort(arr, p + 1, r);
	}

	public static <T extends Comparable<T>> void sort(T[] arr) {
		int n = arr.length - 1;
		quickSort(arr, 0, n - 1);
	}

	private static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
		T t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		// Quick Sort也是一个O(nlogn)复杂度的算法
		// 可以在1秒之内轻松处理100万数量级的数据
		int N = 1000000;
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
		SortTestHelper.testSort("com.practice.oct31.QuickSort", arr);

		return;
	}

}
