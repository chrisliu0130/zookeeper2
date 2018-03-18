package com.atguigu;

public class TestDemo {

	public static void main(String[] args) {
		ResourceData rd = new ResourceData();
		
		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				rd.print5(i);
			}

		}, "A").start();

		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				rd.print10(i);
			}
		}, "B").start();

		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				rd.print15(i);
			}
		}, "C").start();
	}
}
