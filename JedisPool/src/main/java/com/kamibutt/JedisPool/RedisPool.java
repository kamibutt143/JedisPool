package com.kamibutt.JedisPool;

import com.kamibutt.JedisPool.Config.RedisPoolConfig;
import com.kamibutt.JedisPool.Config.ServiceConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {

	private static JedisPool pool;
	private static int objectCount;

	private RedisPool() {
	}

	public static int getObjectCount() {
		return objectCount;
	}

	public static Jedis getJedisObject() {
		objectCount++;
		return pool.getResource();
	}

	private static JedisPoolConfig buildPoolConfig(RedisPoolConfig rpConfig) {
		final JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(rpConfig.getMaxTotal());
		poolConfig.setMaxIdle(rpConfig.getMaxIdle());
		poolConfig.setMinIdle(rpConfig.getMinIdle());
		poolConfig.setTestOnBorrow(rpConfig.isTestOnBorrow());
		poolConfig.setTestOnReturn(rpConfig.isTestOnReturn());
		poolConfig.setTestWhileIdle(rpConfig.isTestWhileIdle());
		poolConfig.setMinEvictableIdleTimeMillis(rpConfig.getMinEvictableIdleTimeMillis());
		poolConfig.setTimeBetweenEvictionRunsMillis(rpConfig.getTimeBetweenEvictionRunsMillis()); // Duration.ofSeconds(30).toMillis()
		poolConfig.setNumTestsPerEvictionRun(rpConfig.getNumTestsPerEvictionRun());
		poolConfig.setMaxWaitMillis(rpConfig.getMaxWaitMillis());
		return poolConfig;
	}

	public static void init(ServiceConfig config) {
		if (pool == null) {
			synchronized (RedisPool.class) {
				if (pool == null) {
					pool = new JedisPool(buildPoolConfig(config.getRedisPoolConfig()),
							config.getRedisServerConfig().getHost(), config.getRedisServerConfig().getPort(),
							config.getRedisServerConfig().getTimeout());
					objectCount = 0;
				}
			}
		}
	}
}
