package com.practice.nov15;

public class DynamicVector<Item> {
	private Item[] data;
	private int size; // Numbers of elements stored in the vector
	private int capacity; // The max number the vector can store

	@SuppressWarnings("unchecked")
	public DynamicVector(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		data = (Item[]) new Object[capacity];
	}

	public DynamicVector() {
		this(10);
	}

	private void resize(int newCapacity) {

		assert newCapacity >= size;
		@SuppressWarnings("unchecked")
		Item[] newData = (Item[]) new Object[newCapacity];
		for (int i = 0; i < size; ++i)
			newData[i] = data[i];
		data = newData;
		capacity = newCapacity;
	}

	public void push_back(Item e) {

		if (size == capacity)
			resize(2 * capacity);
		data[size++] = e;
	}

	public Item pop_back(Item e) {
		if (size <= 0)
			throw new IllegalArgumentException("Cannot pop back for empty vector");
		Item ret = data[size - 1];
		size--;

		if (size == capacity / 4)
			resize(capacity / 2);
		return ret;
	}

	public Item at(int index) {
		if (index < 0 || index >= size)
			throw new IllegalArgumentException("index is out of bound");
		return data[index];
	}

	public Item back() {
		if (size > 0)
			throw new IllegalArgumentException("Vector needs at least one element to call back()");
		return data[size - 1];
	}

	public int getSize() {
		return size;
	}

	public int getCapacity() {
		return capacity;
	}

	public static void main(String[] args) {
		for (int i = 10; i <= 26; i++) {
			int n = (int) Math.pow(2, i);
			long startTime = System.currentTimeMillis();
			DynamicVector<Integer> vec = new DynamicVector<Integer>();
			for (int num = 0; num < n; num++) {
				vec.push_back(num);
			}
			for (int num = 0; num < n; ++num) {
				vec.pop_back(num);
			}
			long endTime = System.currentTimeMillis();
			System.out.println(2 * n + " operations: \t");
			System.out.println((endTime - startTime) + " ms");
		}
	}
}
