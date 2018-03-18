package com.atguigu;

/*
 * 测试的资源类 
 */
public class ResourceClass {

	private int number = 0;

	public synchronized void increment() throws InterruptedException {

		while (number != 0) {
			this.wait();
		}
		++number;
		System.out.println(number);
		this.notifyAll();
	}

	public synchronized void decrement() throws InterruptedException {

		while (number == 0) {
			this.wait();
		}
		--number;
		System.out.println(number);
		this.notifyAll();
	}
}
