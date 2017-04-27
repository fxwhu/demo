package com.bmss.lua;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.DefaultStringRedisConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CacheSha1 {
	
	private static Logger LOGGER = LoggerFactory.getLogger(CacheSha1.class);

	@Autowired
	@Qualifier("script1")
	RedisScript<String> script1;

	@Autowired
	@Qualifier("script2")
	RedisScript<String> rbScript;
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	

	private Map<String, String> cache = new ConcurrentHashMap<>();

	public String evalsha(final String sha, final String... args) throws Exception {
		String ret = redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection) {
				Jedis jedis = (Jedis) connection.getNativeConnection();
				return (String) new String(
						(byte[]) jedis.evalsha(sha.getBytes(), args.length, stringToByte(args)));
			}
		}, true);
		return ret;
	}

	public String get(CacheKeyEnum key) {
		if (cache.get(key.name()) == null) {
			String sha1;
			switch (key) {
				case TEST:
					sha1 = script1.getSha1();
					scriptload(script1);
					break;
				case TEST2:
					sha1 = rbScript.getSha1();
					scriptload(rbScript);
					break;
			default:
				throw new IllegalArgumentException("key值设置不对" + key);
			}
			cache.put(key.name(), sha1);
		}
		LOGGER.info("key: " + key.name() + " ,key's sha1: " + cache.get(key.name()));
		return cache.get(key.name());
	}
	
	
	private void scriptload(RedisScript<String> rediScript){
		final String scriptText = rediScript.getScriptAsString();
		redisTemplate.execute(new RedisCallback<String>(){
			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				DefaultStringRedisConnection newConnection = new DefaultStringRedisConnection(connection);
				return newConnection.scriptLoad(scriptText);
			}
		});
	}


	public static byte[][] stringToByte(String[] strs) {
		byte[][] bytes = new byte[strs.length][];
		List<byte[]> list = new ArrayList<byte[]>(strs.length);
		for (String str : strs) {
			list.add(str.getBytes());
		}
		return list.toArray(bytes);
	}

}
