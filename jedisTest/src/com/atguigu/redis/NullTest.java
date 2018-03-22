package com.atguigu.redis;

import redis.clients.jedis.Jedis;

public class NullTest {

	public static void main(String[] args) {

		Jedis j = new Jedis("192.168.220.128", 6379);
		String aa = j.get("aa");
		j.close();

		System.out.println(aa);
	}

}
