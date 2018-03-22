package com.atguigu.test;

import java.util.HashMap;
import java.util.UUID;

public class Test02
{
//http://www.importnew.com/17481.html
	public static void main(String[] args) throws InterruptedException
	{
		final HashMap<String, String> map = new HashMap<String, String>(2);

		Thread t = new Thread(new Runnable(){
			@Override
			public void run()
			{
				for (int i = 0; i < 10000; i++)
				{
					new Thread(new Runnable(){
						@Override
						public void run()
						{
							map.put(UUID.randomUUID().toString(),"");
							System.out.println(map.size());
						}
					}, "F" + i).start();
				}
			}
		}, "F");
		t.start();
		t.join();
	}
}
