package com.practice.oct31;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class MergeSortBU {

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

	private static <T extends Comparable<T>> void merge(T[] arr, int l, int mid, int r) {
		T[] aux = Arrays.copyOfRange(arr, l, r + 1);

		int i = l, j = mid + 1;
		for (int k = l; k <= r; ++k) {
			if (i > mid) {
				arr[k] = aux[j - l];
				j++;
			} else if (j > r) {
				arr[k] = aux[i - l];
				i++;
			} else if (aux[i - l].compareTo(aux[j - l]) <= 0) {
				arr[k] = aux[i - l];
				i++;
			} else {
				arr[k] = aux[j - l];
				j++;
			}
		}
	}

	public static <T extends Comparable<T>> void sort(T[] arr) {
		int n = arr.length;

		// Normal Version
		/*
		 * for (int sz = 1; sz < n; sz <<= 1) { for (int i = 0; i < n - sz; i += (sz <<
		 * 1)) { // 对 arr[i...i+sz-1] 和 arr[i+sz...i+sz+sz-1] 进行归并 merge(arr, i, i + sz
		 * - 1, Math.min(i + sz + sz - 1, n - 1)); } }
		 */

		// Improved Version

		// 对于小数组, 使用插入排序优化
		for (int i = 0; i < n; i += 16) {
			insertionSortforThis(arr, i, Math.min(i + 15, n - 1));
		}

		for (int sz = 16; sz < n; sz <<= 1) {
			for (int i = 0; i < n - sz; i += (sz << 1)) {
				// 对于arr[mid] <= arr[mid+1]的情况,不进行merge
				if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0) {
					merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
				}
			}
		}

	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		// Merge Sort BU 也是一个O(nlogn)复杂度的算法，虽然只使用两重for循环
		// 所以，Merge Sort BU也可以在1秒之内轻松处理100万数量级的数据
		// 注意：不要轻易根据循环层数来判断算法的复杂度，Merge Sort BU就是一个反例
		// 关于这部分陷阱，推荐看我的《玩转算法面试》课程，第二章：《面试中的复杂度分析》：）
		int N = 100;
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
		SortTestHelper.testSort("com.practice.oct31.MergeSortBU", arr);

		return;
	}

}
