package com.atguigu;

/*
 * 线程资源类
 */
public class ResourceData {
	// 12A34B56C
	private boolean judge = true;
	private int codenum = 65;

	public synchronized void setnumber() throws InterruptedException {

		// 2.干活
		for (int i = 1; i <= 52; i++) {
			// 1.判断
			if (judge == false) {
				this.wait();
			}
			if (i % 2 == 0) {
				judge = false;
			}
			System.out.print(i);
		}

		// 3.通知
		this.notifyAll();
	}

	public synchronized void setalppabet() throws InterruptedException {

		// 2.干活
		for (int i = codenum; i < 91; i++) {
			// 1.判断
			if (judge == true) {
				this.wait();
			}
			char a = (char) i;
			System.out.print(a);
			judge = true;

			// 3.通知
			this.notifyAll();
		}

	}
}
