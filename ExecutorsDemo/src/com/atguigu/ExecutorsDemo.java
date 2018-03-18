package com.atguigu;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsDemo {

	public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
		Future<Integer> result = null;

		try {
			for (int i = 1; i <= 15; i++) {
				result = service.schedule(() -> {
					Thread.sleep(400);
					System.out.print(Thread.currentThread().getName());
					return new Random().nextInt(10);
				}, 1, TimeUnit.SECONDS);
				System.out.println("result="+result.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			service.shutdown();
		}

	}

	private static void executorsDemo() {
		// ExecutorService service = Executors.newFixedThreadPool(5);
		// ExecutorService service = Executors.newSingleThreadExecutor();
		ExecutorService service = Executors.newCachedThreadPool();
		Future<Integer> result = null;

		try {
			for (int i = 1; i <= 15; i++) {
				result = service.submit(() -> {
					Thread.sleep(400);
					System.out.print(Thread.currentThread().getName());
					return new Random().nextInt(10);
				});
				System.out.println(result.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			service.shutdown();
		}
	}

}
