package com.zhoutianqi.mq.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhoutianqi.mq.Sender.MessageSender;
import com.zhoutianqi.mq.Sender.Sender;
import com.zhoutianqi.mq.entity.Message;
/**
 * @author zhoutianqi
 * @create 2017.6.2
 */
@RestController
public class TestController {
	@Autowired
	private  Sender sender;
	@Autowired
	private  MessageSender messageSender;
	@RequestMapping(value="/sender")
    public String logout1(){
		sender.send();
		return "sender ok";
    }
	@RequestMapping(value="/messageSender")
    public String logout2(){
		messageSender.sendToRabbitmq(new Message("这是一个对象！"),"aaaaaaaaaaaaaa");
		return "messageSender ok";
    }
	@RequestMapping(value="/messagesSender")
    public String logout3(){
		List<Message> list = new ArrayList<>();
		list.add(new Message("这是一个m1对象！"));
		list.add(new Message("这是一个m2对象！"));
		messageSender.sendListToRabbitmq(list,"list");
		return "messagesSender ok";
    }
	
}
