package com.atguigu;

public class Test {

	public static void main(String[] args) {
		ResourceData rs = new ResourceData();

		new Thread(() -> {
			try {
				for (int i = 0; i < 26; i++) {
					rs.setnumber();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "number").start();

		new Thread(() -> {
			try {
				for (int i = 0; i < 26; i++) {
					rs.setalppabet();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "alppabet").start();

	}

}
