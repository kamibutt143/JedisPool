package com.kamibutt.JedisPool.Config;

import java.util.Properties;

public class ServiceConfig {
	private JedisServerConfig redisServerConfig;
	private RedisPoolConfig redisPoolConfig;

	public ServiceConfig(Properties props) {
		super();

		this.setRedisServerConfig(new JedisServerConfig(props));
		this.setRedisPoolConfig(new RedisPoolConfig(props));
	}

	public JedisServerConfig getRedisServerConfig() {
		return redisServerConfig;
	}

	public void setRedisServerConfig(JedisServerConfig redisServerConfig) {
		this.redisServerConfig = redisServerConfig;
	}

	public RedisPoolConfig getRedisPoolConfig() {
		return redisPoolConfig;
	}

	public void setRedisPoolConfig(RedisPoolConfig redisPoolConfig) {
		this.redisPoolConfig = redisPoolConfig;
	}
}
