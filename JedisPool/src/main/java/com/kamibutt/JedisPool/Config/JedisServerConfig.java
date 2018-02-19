package com.kamibutt.JedisPool.Config;

import java.util.Properties;

public class JedisServerConfig {
	private String host;
	private int port;
	private int timeout;

	public JedisServerConfig(Properties props) {
		super();
		this.host = props.getProperty("redis.host");
		this.port = Integer.parseInt(props.getProperty("redis.port"));
		this.timeout = Integer.parseInt(props.getProperty("redis.timeout"));
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

}
