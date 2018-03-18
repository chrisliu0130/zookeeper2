package com.atguigu;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class LinkedListDemo {

	public static void main(String[] args) {
		linkedListSafeDemo();
	}

	private static void linkedListSafeDemo() {
		List<String> list = new LinkedList<>();
		List<String> al = Collections.synchronizedList(list);

		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				al.add(UUID.randomUUID().toString().substring(0, 4));
				System.out.println(Thread.currentThread().getName() + al);
			}, "AA").start();
		}
	}

	private static void worryLinkedListDemo() {
		List<String> al = new LinkedList<>();

		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				al.add(UUID.randomUUID().toString().substring(0, 4));
				System.out.println(Thread.currentThread().getName() + al);
			}, "AA").start();
		}
	}

}