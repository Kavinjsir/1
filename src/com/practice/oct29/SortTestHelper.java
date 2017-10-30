package com.practice.oct29;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class SortTestHelper {
	public static Integer[] generateRandomArray(int n) {
		Random rand = new Random();
		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = rand.nextInt(n);
		}
		return arr;
	}

	public static <T extends Comparable<T>> boolean isSorted(T a[]) {
		for (int i = 0; i < a.length - 1; ++i) {
			if (a[i].compareTo(a[i + 1]) > 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * https://github.com/liuyubobobo/Play-with-Algorithms/blob/master/02-Sorting-Basic/Course%20Code%20(Java)/04-Selection-Sort-Detect-Performance/src/bobo/algo/SortTestHelper.java
	 * Java Reflection
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 *
	 */
	public static <T extends Comparable<T>> void testSort(String sortName, T arr[]) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		try {
			@SuppressWarnings("rawtypes")
			Class sortClass = Class.forName("com.practice.oct29.SortUseGeneric");

			@SuppressWarnings("unchecked")
			Method sortMethod = sortClass.getMethod(sortName, new Class[] { Comparable[].class });

			Object[] params = new Object[] { arr };

			long time1 = System.currentTimeMillis();

			sortMethod.invoke(null, params);

			long time2 = System.currentTimeMillis();

			long delta = time2 - time1;

			assert (isSorted(arr));

			System.out.println(sortName + ":" + (double) delta / 1000.0 + "s");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
