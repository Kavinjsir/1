package com.practice.oct31;

import java.lang.reflect.InvocationTargetException;

public class QuickSortTwo {

	private QuickSortTwo() {
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

	// 双路快速排序的partition
	// 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
	private static <T extends Comparable<T>> int partition(T[] arr, int l, int r) {

		// 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
		swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

		T v = arr[l];

		// arr[l+1...i) <= v; arr(j...r] >= v
		int i = l + 1, j = r;
		while (true) {
			// 注意这里的边界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0
			// 思考一下为什么?
			while (i <= r && arr[i].compareTo(v) < 0) {
				i++;
			}

			// 注意这里的边界, arr[j].compareTo(v) > 0, 不能是arr[j].compareTo(v) >= 0
			// 思考一下为什么?
			while (j >= l + 1 && arr[j].compareTo(v) > 0) {
				j--;
			}
			if (i > j) {
				break;
			}
			swap(arr, i, j);
			i++;
			j--;
		}
		return j;
	}

	// 递归使用快速排序,对arr[l...r]的范围进行排序
	private static <T extends Comparable<T>> void sort(T[] arr, int l, int r) {

		// 对于小规模数组, 使用插入排序
		if (r - l <= 15) {
			insertionSortforThis(arr, l, r);
			return;
		}

		int p = partition(arr, l, r);
		sort(arr, l, p - 1);
		sort(arr, p + 1, r);
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

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		// 双路快速排序算法也是一个O(nlogn)复杂度的算法
		// 可以在1秒之内轻松处理100万数量级的数据
		int N = 1000000;
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
		SortTestHelper.testSort("com.practice.oct31.QuickSortTwo", arr);

		return;
	}
}
