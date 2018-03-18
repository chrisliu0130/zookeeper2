package com.atguigu;

import java.util.concurrent.CountDownLatch;

public class SeasonEnumTest {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch cdl = new CountDownLatch(4);
		for (int i = 1; i <= 4; i++) {
			new Thread(() ->{
				System.out.println(Thread.currentThread().getName()+"过完了");
				cdl.countDown();
			}, Season.foreEachSeason(i).getName()).start();
		}

		cdl.await();
		
		System.out.println(Thread.currentThread().getName() + "一年过完了");

	}

}
