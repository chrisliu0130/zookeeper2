package com.atguigu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list = Arrays.asList("a", "b", "c");
		list.forEach(System.out::println);
	}

	private static void arrayListSafeDemo() {
		CopyOnWriteArrayList<String> al = new CopyOnWriteArrayList<>();

		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				al.add(UUID.randomUUID().toString().substring(0, 4));
				System.out.println(Thread.currentThread().getName() + al);
			}, "AA").start();
		}
	}

	private static void arrayListConcurrentDemo() {
		List<String> al = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				al.add(UUID.randomUUID().toString().substring(0, 4));
				System.out.println(Thread.currentThread().getName() + al);
			}, "AA").start();
		}
	}

}
