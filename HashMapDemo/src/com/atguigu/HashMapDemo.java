package com.atguigu;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapDemo {

	public static void main(String[] args) {
		Map<Integer, String> hm = new ConcurrentHashMap<Integer, String>();
		for (int i = 0; i < 30; i++) {
			int temp = i;
			new Thread(() -> {
				hm.put(temp, UUID.randomUUID().toString().substring(0, 4));
				System.out.println(hm);
			}, String.valueOf(i)).start();
			
		}
	}

	private static void hashMapDemo() {
		HashMap<Integer, String> hm = new HashMap<>();

		for (int i = 0; i < 30; i++) {
			int temp = i;
			new Thread(() -> {
				hm.put(temp, UUID.randomUUID().toString().substring(0, 4));
				System.out.println(hm);
			}, String.valueOf(i)).start();
			
		}
	}

}
