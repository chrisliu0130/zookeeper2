package com.atguigu;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch cdl = new CountDownLatch(6);

		for (int i = 1; i <= 6; i++) {
			int temp = i;
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + "国被灭亡");
				cdl.countDown();
			}, CountryEnums.forEachCountry(i).getRetMsg()).start();
		}

		cdl.await();

		System.out.println(Thread.currentThread().getName() + "秦灭六国，一统华夏");

	}

	private static void countDownLatchTest() throws InterruptedException {
		CountDownLatch cdl = new CountDownLatch(6);

		for (int i = 1; i <= 6; i++) {
			int temp = i;
			new Thread(() -> {
				System.out.println(temp + "离开教室");
				cdl.countDown();
			}, String.valueOf(i)).start();
		}

		cdl.await();

		System.out.println(Thread.currentThread().getName() + "锁门");
	}

}
