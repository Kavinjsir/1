package com.practice.oct25.thread;

class RunnableDemo implements Runnable{
	
	private String name;
	public RunnableDemo(String name) {
		this.name = name;
	}
	
	public void run() {
		for(int i = 0; i < 50; ++i) {
			
			//sleep
//			try {
//				Thread.sleep(1000);
//				System.out.println(name + ":" + i);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			//yield
			System.out.println(name + ":" + i);
			if(i == 10) {
				System.out.println("礼让");
				Thread.yield();
			}
		}
	}
}

public class ThreadDemo03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunnableDemo r1 = new RunnableDemo("A");
		RunnableDemo r2 = new RunnableDemo("B");
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		
		//join
//		for(int i = 0; i < 50; i++) {
//			if(i > 10) {
//				try {
//					t1.join();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			System.out.println("Main thread: " + i);
//		}
	}

}
