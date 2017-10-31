package com.practice.oct31;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {

	
    // 比较InsertionSort和MergeSort两种排序算法的性能效率
    // 整体而言, MergeSort的性能最优, 对于近乎有序的数组的特殊情况, 见测试2的详细注释
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
        int N =1000000;
        
        //Test1 General Test
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");


        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("com.practice.oct31.QuickSortTwo", arr1);
        SortTestHelper.testSort("com.practice.oct31.MergeSort", arr2);
        SortTestHelper.testSort("com.practice.oct31.MergeSortBU", arr3);
        SortTestHelper.testSort("com.practice.oct31.QuickSortThree", arr4);

        System.out.println();
        
        //Test2 Nearly Ordered Array Test
        
        // 测试2 测试近乎有序的数组
        // 对于近乎有序的数组, 数组越有序, InsertionSort的时间性能越趋近于O(n)
        // 所以可以尝试, 当swapTimes比较大时, MergeSort更快
        // 但是当swapTimes小到一定程度, InsertionSort变得比MergeSort快
        int swapTimes = 10;
        assert swapTimes >= 0;
        

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("com.practice.oct31.QuickSortTwo", arr1);
        SortTestHelper.testSort("com.practice.oct31.MergeSort", arr2);
        SortTestHelper.testSort("com.practice.oct31.MergeSortBU", arr3);
        SortTestHelper.testSort("com.practice.oct31.QuickSortThree", arr4);

        
        return;
	}

}
