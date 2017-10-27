package com.zhoutianqi.redis.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;


@Configuration
@ConfigurationProperties(prefix="spring.redis")
public class RedisConf {
	/**
	* @author zhoutianqi
	* @className RedisConf.java
	* @date 2017年6月5日 上午10:32:08
	* @description 
	*/
	/**
	 * @ConfigurationProperties注入了对Redis的密码配置(默认是null),不信的话，大家可以看下源码JedisConnectionFactory
	 * JedisConnectionFactory里面封装了JedisShardInfo
	 * 有必要的话，可以自定义配置JedisShardInfo、poolConfig
	*/
	@Bean
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(poolmaxactive);
		poolConfig.setMaxIdle(poolmaxidle);
		poolConfig.setMinIdle(poolminidle);
		poolConfig.setMaxWaitMillis(poolmaxwait);
        return poolConfig;
    }
	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setHostName(host);
		factory.setPassword(password);
		factory.setPort(port);
		factory.setTimeout(timeout);
        return factory;
    }
	//泛型RedisTemplate
    @Bean
    public <T> RedisTemplate<String, T> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, T> template = new RedisTemplate<String, T>();
        //从jedisConnectionFactory获取Jedis实例
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        //序列化与反序列化
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }
    private String host;
	private String password;
	private int port;
	private int poolmaxactive;
	private int poolmaxwait;
	private int poolmaxidle;
	private int poolminidle;
	private int timeout;
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public int getPoolmaxactive() {
		return poolmaxactive;
	}
	public void setPoolmaxactive(int poolmaxactive) {
		this.poolmaxactive = poolmaxactive;
	}
	public int getPoolmaxwait() {
		return poolmaxwait;
	}
	public void setPoolmaxwait(int poolmaxwait) {
		this.poolmaxwait = poolmaxwait;
	}
	public int getPoolmaxidle() {
		return poolmaxidle;
	}
	public void setPoolmaxidle(int poolmaxidle) {
		this.poolmaxidle = poolmaxidle;
	}
	public int getPoolminidle() {
		return poolminidle;
	}
	public void setPoolminidle(int poolminidle) {
		this.poolminidle = poolminidle;
	}
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
