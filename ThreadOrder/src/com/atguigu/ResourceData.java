package com.atguigu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ResourceData {
	private Lock lock = new ReentrantLock();
	ReentrantReadWriteLock lock1=new ReentrantReadWriteLock();
	private int stat = 0;

	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	private Condition c3 = lock.newCondition();
	
	

	public void print5(int total) {
		lock.lock();
		try {
			while (stat != 0) {
				c1.await();
			}
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + i + "total:" + total);
			}
			c2.signal();
			stat = 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void print10(int total) {
		lock.lock();
		try {
			while (stat != 1) {
				c2.await();
			}
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + i + "total:" + total);
			}
			stat = 2;
			c3.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void print15(int total) {
		lock.lock();
		try {
			while (stat != 2) {
				c3.await();
			}
			for (int i = 0; i < 15; i++) {
				System.out.println(Thread.currentThread().getName() + i + "total:" + total);
			}
			stat = 0;
			c1.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
