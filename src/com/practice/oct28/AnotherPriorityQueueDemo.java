package com.practice.oct28;

import java.util.Comparator;
import java.util.PriorityQueue;

class StringLengthComparator implements Comparator<String> {
	@Override
	public int compare(String x, String y) {
		return x.length() - y.length();
	}
}

public class AnotherPriorityQueueDemo {

	public static void main(String[] args) {
		Comparator<String> comparator = new StringLengthComparator();
		PriorityQueue<String> queue = new PriorityQueue<String>(1, comparator);
		queue.add("short");
		queue.add("very long indeed");
		queue.add("medium");
		queue.add("it is long");
		queue.add("short");
		queue.add("very long indeed");
		queue.add("medium");
		queue.add("it is long");
		while (queue.size() != 0) {
			System.out.println(queue.poll());
		}
	}
}
