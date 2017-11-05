package com.practice.nov05;

public class UnionFind5 {
	private int[] parent;
	private int[] rank;
	private int count;

	public UnionFind5(int n) {
		count = n;
		rank = new int[count];
		parent = new int[count];
		for (int i = 0; i < n; ++i) {
			parent[i] = i;
			rank[i] = 1;
		}
	}

	private int find(int p) {
		assert (p >= 0 && p < count);
		
		
		while (p != parent[p]) {
			parent[p] = parent[parent[p]];
			p = parent[p];
		}
		return p;
		
		
		/*
		if(p != parent[p]) {
			parent[p] = find(parent[p]);
		}
		return parent[p];
		*/
	}

	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

	public void unionElements(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);

		if (pRoot == qRoot) {
			return;
		}

		if (rank[pRoot] < rank[qRoot]) {
			parent[pRoot] = qRoot;
		} else if (rank[qRoot] < rank[pRoot]) {
			parent[qRoot] = pRoot;
		} else {
			parent[pRoot] = qRoot;
			rank[qRoot] += 1;
		}
	}
}
