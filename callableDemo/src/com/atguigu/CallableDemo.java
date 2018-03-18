package com.atguigu;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println(123123);
		return 200;
	}

}

public class CallableDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<Integer> ft = new FutureTask<>(new MyThread());
		FutureTask<Integer> ft1 = new FutureTask<Integer>(() -> {
			System.out.println(123123);
			return 200;
		});

		
	// new Thread(ft, "aa").start();
	new Thread(ft1,"bb").start();

	Integer i = ft1.get();

	System.out.println("i:"+i);

}

}
