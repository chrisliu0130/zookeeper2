package com.atguigu;

import java.util.concurrent.locks.ReentrantLock;

public class Ticket {

	private int number = 100;
	private ReentrantLock rl = new ReentrantLock();

	public void sell() {

		rl.lock();
		try {
			if(number>0) {
				System.out.println(Thread.currentThread().getName()+"正在买票，票量还剩"+(--number)+"张");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rl.unlock();
		}
	}
}
