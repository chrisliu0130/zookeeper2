package com.atguigu;

public class TestDemo {

	public static void main(String[] args) {
		ResourceClass rc = new ResourceClass();

		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				try {
					rc.increment();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "AA").start();

		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				try {
					rc.decrement();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "BB").start();
	}

}
