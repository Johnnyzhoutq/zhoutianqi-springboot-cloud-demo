package com.zhoutianqi.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhoutianqi.redis.entity.User;

@RestController
public class RedisController {
	/**
	* @author zhoutianqi
	* @className RedisController.java
	* @date 2017年6月5日 上午10:49:18
	* @description 
	*/
	@Autowired
	private RedisTemplate<String, User> redisTemplate;
	@RequestMapping(value = "redis")
	public String testRedis(){
		redisTemplate.opsForValue().set("zhoutianqi", new User("zhoutianqi","123456"));
		User currentUser = redisTemplate.opsForValue().get("zhoutianqi");
		System.out.println("Redis获取对象："+currentUser.toString());
		return "OK";
	}
}
