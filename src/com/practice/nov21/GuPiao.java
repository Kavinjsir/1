package com.practice.nov21;

public class GuPiao {

	//int[] arr = { 1, 4, 5, 2, 6, 8, 0, 3, 7 };
	public static int[] getBestRise(int[] arr, int res, int i, int j) {
		int len = arr.length, minBuy = 0, maxBuy = 1;
		while (i < len - 1) {
			j = i + 1;
			if (arr[j] <= arr[i]) {
				i++;
				continue;
			} else {
				while (j < len && arr[j] > arr[j - 1]) {
					j++;
				}
				if(arr[minBuy] > arr[i]) {
					minBuy = i;
				}
				if(arr[j - 1] - arr[minBuy] > res) {
					res = arr[j - 1] - arr[i];
					maxBuy = j - 1;
				}
				i = j;
			}
		}
		i = minBuy;
		j = maxBuy;
		res = arr[j] - arr[i];
		return new int[] {i, j, res};
	}

	public static void main(String[] args) {

		int res = 0, i = 0, j = 0;
		int[] arr = { 1, 4, 5, 2, 6, 8, 0, 3, 7 };
		int[] r = getBestRise(arr, res, i, j);

		System.out.println("Best Rise : " + r[2]);
		System.out.println("Buy Time  : " + r[0]);
		System.out.println("Sell time : " + r[1]);
	}

}
