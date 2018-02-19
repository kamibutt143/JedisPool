package com.kamibutt.JedisPool;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.kamibutt.JedisPool.Config.ServiceConfig;

import redis.clients.jedis.Jedis;

public class App {
	public static final String PROPERTIES_FILE = "server.properties";

	public static void main(String[] args) {
		Jedis cache = null;
		try {
			Properties props = new Properties();
			props.load(new FileInputStream(new File(PROPERTIES_FILE)));
			ServiceConfig config = new ServiceConfig(props);
			
			//Initialize Redis Pool Object
			RedisPool.init(config);

			// Example
			String key = "demoKey";
			String value = "demoValue";

			// Fetch Jedis Object from pool.
			cache = RedisPool.getJedisObject();

			// Following set command will save object in memory.
			cache.set(key, value);

			// Following get command will get value from cache.
			String result = cache.get(key);
			System.out.println(result);

			// Following delete command will delete object from cache.
			cache.del(key);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Following close command will return the object to the pool.
			if (cache != null)
				cache.close();
		}

	}
}
