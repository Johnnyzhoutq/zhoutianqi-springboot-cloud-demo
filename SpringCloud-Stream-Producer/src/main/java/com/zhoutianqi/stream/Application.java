package com.zhoutianqi.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.zhoutianqi.stream.producer.UserChannel;

@SpringBootApplication
@EnableBinding(UserChannel.class)
public class Application {
	/**
	* @author zhoutianqi
	* @className Application.java
	* @date 2017年6月5日 上午10:30:40
	* @description 
	*/
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
