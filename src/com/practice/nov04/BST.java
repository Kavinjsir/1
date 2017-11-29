package com.practice.nov04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<Key extends Comparable<Key>, Value> {

	private class Node {
		private Key key;
		private Value value;
		private Node left;
		private Node right;

		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
			this.left = this.right = null;
		}

		public Node(Node node) {
			this.key = node.key;
			this.value = node.value;
			this.left = node.left;
			this.right = node.right;
		}
	}

	private Node root;
	private int count;

	public BST() {
		root = null;
		count = 0;
	}

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public void insert(Key key, Value value) {
		root = insert(root, key, value);
	}

	private Node insert(Node node, Key key, Value value) {
		if (node == null) {
			count++;
			return new Node(key, value);
		}

		Node p = node;
		while (p != null) {
			if (p.key.compareTo(key) == 0) {
				p.value = value;
				return node;
			} else if (p.key.compareTo(key) < 0) {
				if (p.left == null) {
					p.left = new Node(key, value);
					count++;
					return node;
				}
				p = p.left;
			} else {
				if (p.right == null) {
					p.right = new Node(key, value);
					count++;
					return node;
				}
				p = p.right;
			}
		}
		return node;
	}

	public boolean contain(Key key) {
		return contain(root, key);
	}

	private boolean contain(Node node, Key key) {
		Node p = node;
		while (p != null) {
			if (p.key.compareTo(key) == 0) {
				return true;
			} else if (p.key.compareTo(key) < 0) {
				p = p.left;
			} else {
				p = p.right;
			}
		}
		return false;
	}

	public Value search(Key key) {
		return search(root, key);
	}

	private Value search(Node node, Key key) {
		Node p = node;
		while (p != null) {
			if (p.key.compareTo(key) == 0) {
				return p.value;
			} else if (p.key.compareTo(key) < 0) {
				p = p.left;
			} else {
				p = p.right;
			}
		}
		return null;
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node node) {
		Node p = node;
		Stack<Node> stack = new Stack<Node>();
		while (!stack.isEmpty() || p != null) {
			while (p != null) {
				System.out.println(p.key + " " + p.value);
				stack.push(p);
				p = p.left;
			}
			if (!stack.isEmpty()) {
				p = stack.pop();
				p = p.right;
			}
		}
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node node) {
		Node p = node;
		Stack<Node> stack = new Stack<Node>();
		while (!stack.isEmpty() || p != null) {
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
			if (!stack.empty()) {
				p = stack.pop();
				System.out.println(p.key + " " + p.value);
				p = p.right;
			}
		}
	}

	public void postOrder() {
		postOrder(root);
	}

	
	//Might be wrong!
	private void postOrder(Node node) {
		Node p = node;
		Stack<Node> stack = new Stack<Node>();
		while (!stack.isEmpty() || p != null) {
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
			if (!stack.empty()) {
				p = stack.peek();
				if (p.right == null) {
					p = stack.pop();
					System.out.println(p.key + " " + p.value);
				} else {
					p = p.right;
					stack.push(p);
				}
			}
		}
	}

	public void levelOrder() {
		levelOrder(root);
	}

	private void levelOrder(Node node) {
		Queue<Node> q = new LinkedList<Node>();
		Node p = node;
		q.offer(p);
		while (!q.isEmpty()) {
			p = q.poll();
			System.out.println(p.key + " " + p.value);
			if (p.left != null) {
				q.offer(p.left);
			}
			if (p.right != null) {
				q.offer(p.right);
			}
		}
	}

	public Key minimum() {
		assert (count > 0);
		Node p = minimum(root);
		return p.key;
	}

	private Node minimum(Node node) {
		Node p = node;
		while (p.left != null) {
			p = p.left;
		}
		return p;
	}

	public Key maximum() {
		assert (count > 0);
		Node p = maximum(root);
		return p.key;
	}

	private Node maximum(Node node) {
		Node p = node;
		while (p.right != null) {
			p = p.right;
		}
		return p;
	}

	public void removeMin() {
		root = removeMin(root);
	}

	private Node removeMin(Node node) {
		Node p = node;
		if (p == null) {
			return null;
		}
		if (p.left == null) {
			if (p.right != null) {
				p.key = p.right.key;
				p.value = p.right.value;
				p.left = p.right.left;
				p.right = p.right.right;
				count--;
				return p;
			} else {
				count--;
				return null;
			}
		}
		while (p.left.left != null) {
			p = p.left;
		}
		p.left = null;
		count--;
		return node;
	}

	public void removeMax() {
		root = removeMax(root);
	}

	private Node removeMax(Node node) {
		if (node == null) {
			return null;
		}
		if (node.right == null) {
			if (node.left != null) {
				node.key = node.left.key;
				node.value = node.left.value;
				node.right = node.left.right;
				node.left = node.left.left;
				count--;
				return node;
			} else {
				return null;
			}
		}
		Node p = node;
		while (p.right.right != null) {
			p = p.right;
		}
		p.right = null;
		count--;
		return node;
	}

	public void remove(Key key) {
		if (root != null) {
			root = remove(root, key);
		}
	}

	@SuppressWarnings("unused")
	private Node remove(Node node, Key key) {
		if (node == null) {
			return null;
		}

		Node p = node;
		while (key.compareTo(p.key) != 0) {
			if (key.compareTo(p.key) < 0) {
				p = p.left;
			} else {
				p = p.right;
			}
		}
		if (p == null) {
			System.out.println("No such key.");
			return node;
		}

		if (p.left == null) {
			if (p.right == null) {
				p = null;
				count--;
				return node;
			} else {
				p.key = p.right.key;
				p.value = p.right.value;
				p.left = p.right.left;
				p.right = p.right.right;
				count--;
				return node;
			}
		} else {
			if (p.right == null) {
				p.key = p.left.key;
				p.value = p.left.value;
				p.right = p.left.right;
				p.left = p.left.left;
				count--;
				return node;
			} else {
				Node t = new Node(minimum(p.right));
				Node c = removeMin(p.right);
				p.key = t.key;
				p.value = t.value;
				p.right = t.right;
				p.left = t.left;
				count--;
				return node;
			}
		}
	}

	public static void main(String[] args) {
        int N = 1000000;

        // 创建一个数组，包含[0...N)的所有元素
        Integer[] arr = new Integer[N];
        for(int i = 0 ; i < N ; i ++)
            arr[i] = new Integer(i);

        // 打乱数组顺序
        for(int i = 0 ; i < N ; i ++){
            int pos = (int) (Math.random() * (i+1));
            Integer t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = arr[pos];
        }
        // 由于我们实现的二分搜索树不是平衡二叉树，
        // 所以如果按照顺序插入一组数据，我们的二分搜索树会退化成为一个链表
        // 平衡二叉树的实现，我们在这个课程中没有涉及，
        // 有兴趣的同学可以查看资料自学诸如红黑树的实现
        // 以后有机会，我会在别的课程里向大家介绍平衡二叉树的实现的：）


        // 我们测试用的的二分搜索树的键类型为Integer，值类型为String
        // 键值的对应关系为每个整型对应代表这个整型的字符串
        BST<Integer,String> bst = new BST<Integer,String>();
        for(int i = 0 ; i < N ; i ++)
            bst.insert(new Integer(arr[i]), Integer.toString(arr[i]));

        // 对[0...2*N)的所有整型测试在二分搜索树中查找
        // 若i在[0...N)之间，则能查找到整型所对应的字符串
        // 若i在[N...2*N)之间，则结果为null
        for(int i = 0 ; i < 2*N ; i ++){
            String res = bst.search(new Integer(i));
            if( i < N )
                assert res == Integer.toString(i);
            else
                assert res == null;
        }

	}

}
