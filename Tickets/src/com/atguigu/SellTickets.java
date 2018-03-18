package com.atguigu;

public class SellTickets {

	public static void main(String[] args) {
		Ticket ticket = new Ticket();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 100; i++) {
					ticket.sellTicket();
				}
			}
		}, "AA").start();

		/****************************************************************/
		new Thread(() -> {
			for (int i = 1; i <= 100; i++)
				ticket.sellTicket();
		}, "CC").start();
		/****************************************************************/

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 100; i++) {
					ticket.sellTicket();
				}
			}
		}, "BB").start();

		/****************************************************************/
		new Thread(() -> {
			for (int i = 1; i <= 5; i++)
				System.out.println("123");
		}).start();

	}

}
