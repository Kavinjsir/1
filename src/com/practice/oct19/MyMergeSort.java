package com.practice.oct19;

public class MyMergeSort {

	private static int[] mergeSort(int[] a) {
		if (a.length == 1) {
			return a;
		} else if (a.length == 2) {
			if (a[0] > a[1]) {
				a[0] = a[0] + a[1];
				a[1] = a[0] - a[1];
				a[0] = a[0] - a[1];
			}
			return a;
		} else {
			int[] b = new int[a.length / 2];
			System.arraycopy(a, 0, b, 0, a.length / 2);
			int[] b1 = mergeSort(b);

			int[] c = new int[a.length - a.length / 2];
			System.arraycopy(a, a.length / 2, c, 0, a.length - a.length / 2);
			int[] c1 = mergeSort(c);

			int[] res = new int[b1.length + c1.length];
			int posB = b1.length - 1;
			int posC = c1.length - 1;
			int pos = res.length - 1;
			while (pos >= 0) {
				if (posB < 0) {
					while (posC >= 0) {
						res[pos--] = c1[posC--];
					}
				} else if (posC < 0) {
					while (posB >= 0) {
						res[pos--] = b1[posB--];
					}
				} else {
					if (b1[posB] > c1[posC]) {
						res[pos--] = b1[posB--];
					} else {
						res[pos--] = c1[posC--];
					}
				}
			}
			return res;

		}
	}

	private static void reverse(int a[], int i, int j) {
		while (i < j) {
			a[i] += a[j];
			a[j] = a[i] - a[j];
			a[i] = a[i] - a[j];
			i++;
			j--;
		}
	}

	private static void swapBlocks(int a[], int start, int len, int len2) {
		reverse(a, start, start + len - 1);
		reverse(a, start + len, start + len + len2 - 1);
		reverse(a, start, start + len + len2 - 1);
	}

	private static void inplaceMerge(int a[], int l, int mid, int r) {
		int i = l;
		int j = mid + 1;
		int index = 0;
		while (i < j && j <= r) {
			while (i < j && a[i] <= a[j]) {
				i++;
			}
			index = j;
			while (j <= r && a[j] <= a[i]) {
				j++;
			}
			swapBlocks(a, i, index - i, j - index);
			i += (j - index);
		}
	}

	private static void inplaceMergeSort(int a[], int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			inplaceMergeSort(a, l, mid);
			inplaceMergeSort(a, mid + 1, r);
			inplaceMerge(a, l, mid, r);
		}
	}

	public static void main(String[] args) {
		int[] a = { 10, 4, 6, 3, 8, 2, 7, 5, 1 };
		// Common mergeSort
		int[] res = mergeSort(a);
		for (Integer i : res) {
			System.out.print(i + " ");
		}

		System.out.println();

		// Inplace mergeSort
		inplaceMergeSort(a, 0, a.length - 1);
		for (Integer j : a) {
			System.out.print(j + " ");
		}
	}
}
