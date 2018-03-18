package com.atguigu;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(7, () -> {
			System.out.println(Thread.currentThread().getName() + "号召唤神龙");
		});

		for (int i = 1; i <= 7; i++) {
			new Thread(() -> {

				try {
					System.out.println(Thread.currentThread().getName()+"号队伍收集到了龙珠");
					cb.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}, String.valueOf(i)).start();
		}

	}

}
