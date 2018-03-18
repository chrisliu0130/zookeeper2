package com.atguigu;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

	public static void main(String[] args) {
		Semaphore s = new Semaphore(3);

		for (int i = 1; i <= 6; i++) {
			new Thread(() ->{
				try {
					s.acquire();
					System.out.println(Thread.currentThread().getName()+"抢占了位置");
					TimeUnit.SECONDS.sleep(new Random().nextInt(5));
					System.out.println(Thread.currentThread().getName()+"离开了位置");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					s.release();
				}
			},String.valueOf(i)).start();
				
		}
	}

}
