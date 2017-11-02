package com.practice.nov02;

public class Heap<T extends Comparable<T>> {

	private T[] data;
	private int count;
	private int capacity;

	private void shiftUp(int k) {
		while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
			swap(k / 2, k);
			k /= 2;
		}
	}

	private void shiftDown(int k) {
		while (2 * k <= count) {
			int j = 2 * k;
			if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0) {
				j++;
			}
			if (data[k].compareTo(data[j]) >= 0) {
				break;
			}
			swap(k, j);
			k = j;
		}
	}

	// 构造函数，构造一个空堆，可容纳capacity个元素
	@SuppressWarnings("unchecked")
	public Heap(int capacity) {
		data = (T[]) new Comparable[capacity + 1];
		count = 0;
		this.capacity = capacity;
	}

	// 构造函数，通过一个给定数组创建一个最大堆
	// 该构造堆的过程，时间复杂度为O(n)
	@SuppressWarnings("unchecked")
	public Heap(T arr[]) {
		int n = arr.length;
		data = (T[]) new Object[n + 1];
		capacity = n;

		for (int i = 0; i < n; ++i) {
			data[i + 1] = arr[i];
		}
		count = n;

		for (int i = count / 2; i >= 1; --i) {
			shiftDown(i);
		}
	}

	// 返回堆中的元素个数
	public int size() {
		return count;
	}

	// 返回一个布尔值, 表示堆中是否为空
	public boolean isEmpty() {
		return count == 0;
	}

	// 最大堆中插入一个新的元素
	public void insert(T v) {
		assert (count + 1 <= capacity);
		data[count + 1] = v;
		shiftUp(++count);
	}

	// 从最大堆中取出堆顶元素, 即堆中所存储的最大数据
	public T extractMax() {
		assert (count > 0);
		T ret = data[1];
		swap(1, count);
		count--;
		shiftDown(1);
		return ret;
	}

	// 获取最大堆中的堆顶元素
	public T getMax() {
		assert (count > 0);
		return data[1];
	}

	// Print
	public void show() {
		for (int i = 1; i <= count; ++i) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

	private void swap(int i, int j) {
		T t = data[i];
		data[i] = data[j];
		data[j] = t;
	}

	public static <T extends Comparable<T>> void sort(T arr[]) {
		int n = arr.length;
		Heap<T> heap = new Heap<T>(n);
		for (int i = 0; i < n; ++i) {
			heap.insert(arr[i]);
		}

		for (int i = n - 1; i >= 0; --i) {
			arr[i] = heap.extractMax();
		}

	}

	public static void main(String[] args) {

		Heap<Integer> heap = new Heap<Integer>(100);

		for (int i = 0; i < 50; ++i) {
			heap.insert(new Integer((int) (Math.random() * 100)));
		}

		heap.show();

		while (!heap.isEmpty()) {
			System.out.print(heap.extractMax() + " ");
		}
		System.out.println();

		System.out.println(heap.isEmpty());

	}

}
