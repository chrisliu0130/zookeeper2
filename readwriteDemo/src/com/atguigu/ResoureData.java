package com.atguigu;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ResoureData {

	private Object object;
	private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	private Lock lock=new ReentrantLock();

	public void write(Object object) {

		rwl.writeLock().lock();
		try {
			this.object = object;
			System.out.println("write:"+object);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rwl.writeLock().unlock();
		}

	}

	public void read() {

		rwl.readLock().lock();
		try {
      System.out.println(Thread.currentThread().getName()+":read");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rwl.readLock().unlock();
		}

	}

}
