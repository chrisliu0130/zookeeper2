package com.atguigu;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch cdl = new CountDownLatch(6);

		for (int i = 1; i <= 6; i++) {
			int temp = i;
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + "��������");
				cdl.countDown();
			}, CountryEnums.forEachCountry(i).getRetMsg()).start();
		}

		cdl.await();

		System.out.println(Thread.currentThread().getName() + "����������һͳ����");

	}

	private static void countDownLatchTest() throws InterruptedException {
		CountDownLatch cdl = new CountDownLatch(6);

		for (int i = 1; i <= 6; i++) {
			int temp = i;
			new Thread(() -> {
				System.out.println(temp + "�뿪����");
				cdl.countDown();
			}, String.valueOf(i)).start();
		}

		cdl.await();

		System.out.println(Thread.currentThread().getName() + "����");
	}

}
