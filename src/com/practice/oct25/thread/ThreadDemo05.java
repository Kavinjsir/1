package com.practice.oct25.thread;

class MyThreadDemo implements Runnable{
	
	private int ticket = 5;

	//同步方法
//	public void run() {
//		for(int i = 0; i < 10; ++i) {
//			tell();
//		}
//	}
//	public synchronized void tell() {
//		if(ticket > 0) {
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println(Thread.currentThread().getName() + ": " + "Ticket" + ticket--);
//		}
//	}
	
	
	//同步代码块
	public void run() {
		for(int i = 0; i < 10; ++i) {
			synchronized (this) {
				if(ticket > 0) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ": " + "Ticket" + ticket--);
				}
			}
		}
	}
}

public class ThreadDemo05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThreadDemo m = new MyThreadDemo();
		Thread t1 = new Thread(m, "A");
		Thread t2 = new Thread(m, "B");
		Thread t3 = new Thread(m, "C");
		Thread t4 = new Thread(m, "D");
		Thread t5 = new Thread(m, "E");
		Thread t6 = new Thread(m, "F");
		Thread t11 = new Thread(m, "G");
		Thread t21 = new Thread(m, "H");
		Thread t31 = new Thread(m, "I");
		Thread t41 = new Thread(m, "J");
		Thread t51 = new Thread(m, "K");
		Thread t61 = new Thread(m, "L");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t11.start();
		t21.start();
		t31.start();
		t41.start();
		t51.start();
		t61.start();
	}

}
