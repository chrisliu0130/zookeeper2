package com.atguigu;

public class PCTest {

	public static void main(String[] args) {
		    Ticket t=new Ticket();
	
			new Thread(() ->{
				for (int j = 0; j < 100; j++) {
					t.sell();
				}
			},"aa").start();
			
			new Thread(() ->{
				for (int j = 0; j < 100; j++) {
					t.sell();
				}
			},"bb").start();
			
			new Thread(() ->{
				for (int j = 0; j < 100; j++) {
					t.sell();
				}
			},"cc").start();
		
	}

}
