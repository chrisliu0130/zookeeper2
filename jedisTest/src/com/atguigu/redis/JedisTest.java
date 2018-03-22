package com.atguigu.redis;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.omg.Messaging.SyncScopeHelper;

import redis.clients.jedis.Jedis;

public class JedisTest {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.220.128", 6379);
		String ping = jedis.ping();
		System.out.println(ping);

		jedis.set("k10", "v10");
		System.out.println(jedis.get("k10"));

		Set<String> keys = jedis.keys("*");

		for (String string : keys) {
			System.out.print(string + " ");
		}
		System.out.println();
		System.out.println("**********************************");
		jedis.lpush("l1", "lk1");
		List<String> lrange = jedis.lrange("l1", 0, -1);

		for (String string : lrange) {
			System.out.print(string);
		}
		System.out.println();
		System.out.println("**********************************");
		jedis.sadd("s1", "sv1", "sv2", "sv1");
		Set<String> smembers = jedis.smembers("s1");
		for (String string : smembers) {
			System.out.println(string);
		}

		System.out.println("**********************************");
		jedis.hset("id1", "name", "z3");
		String name = jedis.hget("id1", "name");
		System.out.println(name);

		System.out.println();
		System.out.println("**********************************");

		Map<String, String> map = jedis.hgetAll("id1");

		Set<Entry<String, String>> entrySet = map.entrySet();

		for (Entry<String, String> entry : entrySet) {
			System.out.println(entry.toString());
		}

		System.out.println();
		System.out.println("**********************************");

		List<String> list = jedis.hmget("id1", "name", "age", "city");
		for (String string : list) {
			System.out.println(string);
		}

		System.out.println();
		System.out.println("**********************************");

		Set<String> zrange = jedis.zrange("z1", 0, -1);

		for (String string : zrange) {
			System.out.println(string);
		}

		jedis.close();
	}

}
