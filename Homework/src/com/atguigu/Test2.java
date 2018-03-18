package com.atguigu;

public class Test2 {

	public static void main(String[] args) {
		ResourceData2 rs2 = new ResourceData2();

		new Thread(() -> {
			try {
				for (int i = 0; i < 26; i++) {
					rs2.setnumber();
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "number").start();

		new Thread(() -> {
			try {
				for (int i = 0; i < 26; i++) {
					rs2.setalphabet();
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "alppabet").start();

	}

}