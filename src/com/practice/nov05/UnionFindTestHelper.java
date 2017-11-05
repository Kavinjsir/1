package com.practice.nov05;

public class UnionFindTestHelper {

	public static void testUF1(int n) {
		UnionFind1 uf = new UnionFind1(n);

		long startTime = System.currentTimeMillis();

		for (int i = 0; i < n; ++i) {
			int a = (int) (Math.random() * n);
			int b = (int) (Math.random() * n);
			uf.unionElements(a, b);
		}

		for (int i = 0; i < n; ++i) {
			int a = (int) (Math.random() * n);
			int b = (int) (Math.random() * n);
			uf.isConnected(a, b);
		}

		long endTime = System.currentTimeMillis();

		System.out.println("UF1, " + 2 * n + " ops, " + (endTime - startTime) / 1000.0 + "s");
	}

	public static void testUF2(int n) {
		UnionFind2 uf = new UnionFind2(n);

		long startTime = System.currentTimeMillis();

		for (int i = 0; i < n; ++i) {
			int a = (int) (Math.random() * n);
			int b = (int) (Math.random() * n);
			uf.unionElements(a, b);
		}

		for (int i = 0; i < n; ++i) {
			int a = (int) (Math.random() * n);
			int b = (int) (Math.random() * n);
			uf.isConnected(a, b);
		}

		long endTime = System.currentTimeMillis();

		System.out.println("UF2, " + 2 * n + " ops, " + (endTime - startTime) / 1000.0 + "s");
	}
	
	public static void testUF3(int n) {
		UnionFind3 uf = new UnionFind3(n);

		long startTime = System.currentTimeMillis();

		for (int i = 0; i < n; ++i) {
			int a = (int) (Math.random() * n);
			int b = (int) (Math.random() * n);
			uf.unionElements(a, b);
		}

		for (int i = 0; i < n; ++i) {
			int a = (int) (Math.random() * n);
			int b = (int) (Math.random() * n);
			uf.isConnected(a, b);
		}

		long endTime = System.currentTimeMillis();

		System.out.println("UF3, " + 2 * n + " ops, " + (endTime - startTime) / 1000.0 + "s");
	}
	
	public static void testUF4(int n) {
		UnionFind4 uf = new UnionFind4(n);

		long startTime = System.currentTimeMillis();

		for (int i = 0; i < n; ++i) {
			int a = (int) (Math.random() * n);
			int b = (int) (Math.random() * n);
			uf.unionElements(a, b);
		}

		for (int i = 0; i < n; ++i) {
			int a = (int) (Math.random() * n);
			int b = (int) (Math.random() * n);
			uf.isConnected(a, b);
		}

		long endTime = System.currentTimeMillis();

		System.out.println("UF4, " + 2 * n + " ops, " + (endTime - startTime) / 1000.0 + "s");
	}
	
	public static void testUF5(int n) {
		UnionFind5 uf = new UnionFind5(n);

		long startTime = System.currentTimeMillis();

		for (int i = 0; i < n; ++i) {
			int a = (int) (Math.random() * n);
			int b = (int) (Math.random() * n);
			uf.unionElements(a, b);
		}

		for (int i = 0; i < n; ++i) {
			int a = (int) (Math.random() * n);
			int b = (int) (Math.random() * n);
			uf.isConnected(a, b);
		}

		long endTime = System.currentTimeMillis();

		System.out.println("UF5, " + 2 * n + " ops, " + (endTime - startTime) / 1000.0 + "s");
	}
}
