package com.demo.application.conf;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.ElementType;
/**  
* @Title：TargetDataSource.java
* @Author:zhoutianqi
* @Description:自定义注解
* @Date：2017年5月24日下午5:47:02  
*/
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String name();
}