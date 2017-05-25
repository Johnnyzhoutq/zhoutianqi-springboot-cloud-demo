package com.demo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
/**  
* @Title：Application.java
* @Author:zhoutianqi
* @Description:SpringBoot-Mybatis-Datasource入口
* @Date：2017年5月24日下午5:47:02  
*/
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
