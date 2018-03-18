package com.atguigu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public class HashSetDemo {

	public static void main(String[] args) {
		hashSetDemo();
	}

	private static void hashSetSafeDemo() {
		Set<String> set = new CopyOnWriteArraySet<String>();

		for (int i = 0; i < 30; i++) {
			
			new Thread(() ->{
				set.add(UUID.randomUUID().toString().substring(0,3));
				System.out.println(set);
			}).start();
		}
	}

	private static void hashSetDemo() {
		Set<String> set = new HashSet<String>();

		for (int i = 0; i < 30; i++) {
			
			new Thread(() ->{
				set.add(UUID.randomUUID().toString().substring(0,3));
				System.out.println(set);
			}).start();
		}
	}

}
