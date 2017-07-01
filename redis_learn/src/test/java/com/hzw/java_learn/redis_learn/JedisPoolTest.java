package com.hzw.java_learn.redis_learn;

import java.util.ResourceBundle;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolTest {

	private static JedisPool jedisPool;

	/**
	 * initPoolConfig <br>
	 * ------------------------------<br>
	 * 
	 * @return
	 */
	private static JedisPoolConfig initPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		// 控制一个pool最多有多少个状态为idle的jedis实例
//		jedisPoolConfig.setMaxActive(1000);
		// 最大能够保持空闲状态的对象数
		jedisPoolConfig.setMaxIdle(300);
		// 超时时间
		jedisPoolConfig.setMaxWaitMillis(1000);
		// 在borrow一个jedis实例时，是否提前进行alidate操作；如果为true，则得到的jedis实例均是可用的；
		jedisPoolConfig.setTestOnBorrow(true);
		// 在还会给pool时，是否提前进行validate操作
		jedisPoolConfig.setTestOnReturn(true);
		return jedisPoolConfig;
	}

	/**
	 * 初始化jedis连接池 
	 */
	@Before
	public void before() {
		JedisPoolConfig jedisPoolConfig = initPoolConfig();
		// 属性文件读取参数信息
		ResourceBundle bundle = ResourceBundle.getBundle("com.hzw.java_learn.redis_learn.redis");
		String host = bundle.getString("redis.host");
		int port = Integer.valueOf(bundle.getString("redis.port"));
		// 构造连接池
		jedisPool = new JedisPool(jedisPoolConfig, host, port);
	}

	@Test
	public void testSet() {
		Jedis jedis = null;
		// 从池中获取一个jedis实例
		try {
			jedis = jedisPool.getResource();
			jedis.set("blog_pool", "java2000_wl");
		} catch (Exception e) {
			// 销毁对象
			jedisPool.returnBrokenResource(jedis);
			Assert.fail(e.getMessage());
		} finally {
			// 还会到连接池
			jedisPool.returnResource(jedis);
		}
	}

	@Test
	public void testGet() {
		Jedis jedis = null;
		try {
			// 从池中获取一个jedis实例
			jedis = jedisPool.getResource();
			System.out.println(jedis.get("blog_pool"));
		} catch (Exception e) {
			// 销毁对象
			jedisPool.returnBrokenResource(jedis);
			Assert.fail(e.getMessage());
		} finally {
			// 还会到连接池
			jedisPool.returnResource(jedis);
		}
	}
}
