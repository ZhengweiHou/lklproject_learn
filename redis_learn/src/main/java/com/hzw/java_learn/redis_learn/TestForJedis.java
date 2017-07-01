package com.hzw.java_learn.redis_learn;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

public class TestForJedis {
	public static void main(String[] args) {
		// 多节点
//		HostAndPort hap = new HostAndPort("192.168.32.131", 6379);
//		JedisCluster jclu = new JedisCluster(hap);
//		jclu.set("hzw", "123123");
		
		
		
		
		Jedis jedis = new Jedis("192.168.32.131", 6379, 5000);
		System.out.println(jedis.ping());
		jedis.set("hzw", "zhaoyonggang");
		
		System.out.println(jedis.get("zyg"));
		System.out.println(jedis.get("zyg2"));

		System.out.println(jedis.get("b"));
	}
}
