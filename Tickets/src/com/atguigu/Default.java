package com.atguigu;

public class Default {

	public static void main(String[] args) {
		Inter inter = (int x, int y) -> {
			return x + y;
		};
		System.out.println(inter.add(10, 5));
		System.out.println(inter.div(10, 5));
		System.out.println(inter.multi(2, 3, 4));
	}
}

interface Inter {
	public int add(int x, int y);

	default int div(int x, int y) {
		return x / y;
	}

	default int multi(int x, int y, int z) {
		return x * y * z;
	}
}