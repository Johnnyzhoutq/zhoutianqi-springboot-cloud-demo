package com.zhoutianqi.mq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhoutianqi.mq.Sender.Sender;
/**
 * @author zhoutianqi
 * @create 2017.6.2
 */
@RestController
public class TestController {
	@Autowired
	private  Sender sender;
	@RequestMapping(value="/sender")
    public String logout(){
		sender.send();
		return "ok";
    }
	
}
