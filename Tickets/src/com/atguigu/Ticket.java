package com.atguigu;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 多线程中的资源类，高内聚,把对此类的操作都封装在此类中，对外提供接口（方法）
 */
public class Ticket {

	private int numbers = 100;
	Lock lock = new ReentrantLock();

	public void sellTicket() {

		lock.lock();
		try {
			;
			if (numbers > 0) {
				System.out.println(Thread.currentThread().getName() + "线程正在买票，还剩" + --numbers + "张票");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

}
