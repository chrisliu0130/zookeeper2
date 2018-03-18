package com.atguigu;

public class RWDemo {

	public static void main(String[] args) throws InterruptedException {
		ResoureData td = new ResoureData();
		
		for (int i = 1; i <= 50; i++) {
			new Thread(() -> {
				td.read();
			}, String.valueOf(i)).start();
		}
		
		Thread.sleep(400);
		
		new Thread(() -> {
			td.write(123);
		}, "write").start();

	}
}
