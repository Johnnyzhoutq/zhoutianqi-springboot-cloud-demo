package com.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
	/**
	* @author zhoutianqi
	* @className Application.java
	* @date 2017年12月5日 上午10:30:40
	* @description 
	*/
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@RequestMapping("hello")
	public String hello(){
		return "Success!";
	}
}
