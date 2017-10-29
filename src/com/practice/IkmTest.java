package com.practice;

public class IkmTest {
	public static void main(String args[]) throws Exception {
		IkmTest t = new IkmTest();
		t.doSomething();
		Thread.sleep(2000);
	}

	public void doSomething() {
		Object[] objArray = new Object[2];
		for (int i = 0; i < objArray.length; i++) {
			objArray[i] = new Object();
		}
	}
}
