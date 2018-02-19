package com.kamibutt.JedisPool.Config;

import java.util.Properties;

public class RedisPoolConfig {
	private int maxTotal;
	private int maxIdle;
	private int minIdle;
	private boolean testOnBorrow;
	private boolean testOnReturn;
	private boolean testWhileIdle;
	private int minEvictableIdleTimeMillis;
	private int timeBetweenEvictionRunsMillis;
	private int numTestsPerEvictionRun;
	private int maxWaitMillis;

	public RedisPoolConfig(Properties props) {
		this.setMaxTotal(Integer.parseInt(props.getProperty("redisPoolConfig.maxTotal")));
		this.setMaxIdle(Integer.parseInt(props.getProperty("redisPoolConfig.maxIdle")));
		this.setMinIdle(Integer.parseInt(props.getProperty("redisPoolConfig.minIdle")));
		this.setTestOnBorrow(Boolean.getBoolean(props.getProperty("redisPoolConfig.testOnBorrow")));
		this.setTestOnReturn(Boolean.getBoolean(props.getProperty("redisPoolConfig.testOnReturn")));
		this.setTestWhileIdle(Boolean.getBoolean(props.getProperty("redisPoolConfig.testWhileIdle")));
		this.setMinEvictableIdleTimeMillis(
				Integer.parseInt(props.getProperty("redisPoolConfig.minEvictableIdleTimeMillis")));
		this.setTimeBetweenEvictionRunsMillis(
				Integer.parseInt(props.getProperty("redisPoolConfig.timeBetweenEvictionRunsMillis")));
		this.setNumTestsPerEvictionRun(Integer.parseInt(props.getProperty("redisPoolConfig.numTestsPerEvictionRun")));
		this.setMaxWaitMillis(Integer.parseInt(props.getProperty("redisPoolConfig.maxWaitMillis")));
	}

	public int getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}

	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public boolean isTestOnReturn() {
		return testOnReturn;
	}

	public void setTestOnReturn(boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}

	public boolean isTestWhileIdle() {
		return testWhileIdle;
	}

	public void setTestWhileIdle(boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}

	public int getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}

	public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}

	public int getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}

	public int getNumTestsPerEvictionRun() {
		return numTestsPerEvictionRun;
	}

	public void setNumTestsPerEvictionRun(int numTestsPerEvictionRun) {
		this.numTestsPerEvictionRun = numTestsPerEvictionRun;
	}

	public int getMaxWaitMillis() {
		return maxWaitMillis;
	}

	public void setMaxWaitMillis(int maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}

}
