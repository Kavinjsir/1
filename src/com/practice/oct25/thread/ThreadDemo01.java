package com.practice.oct25.thread;

public class ThreadDemo01 {

	public static void main(String[] args) {
		//第一种实现方式：继承Thread类
//		MyThread t1 = new MyThread("A");
//		MyThread t2 = new MyThread("B");
//		t1.start();
//		t2.start();
		
		//第二种实现方式：实现Runnable接口
		MyRunnable r1 = new MyRunnable("A");
		MyRunnable r2 = new MyRunnable("B");
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
}
