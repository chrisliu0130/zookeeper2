package com.atguigu.redis;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class JedisClusterTest {

	public static void main(String[] args) {
		// JedisCluster jc = new JedisCluster(new HostAndPort("192.168.220.128", 6379));
		Set<HostAndPort> nodes = new HashSet<HostAndPort>();
		nodes.add(new HostAndPort("192.168.220.128", 6379));

		JedisCluster jc2 = new JedisCluster(nodes);
	}

}
