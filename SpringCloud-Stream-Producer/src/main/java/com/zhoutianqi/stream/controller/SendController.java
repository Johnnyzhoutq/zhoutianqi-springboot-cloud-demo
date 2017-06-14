package com.zhoutianqi.stream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhoutianqi.stream.entity.User;
import com.zhoutianqi.stream.producer.MyChannel;
import com.zhoutianqi.stream.producer.UserChannel;

@RestController
@EnableBinding(MyChannel.class)//@EnableBinding(MyChannel1.class)，实现与消息代理的连接
public class SendController {
	/**
	* @author zhoutianqi
	* @className SendController.java
	* @date 2017年6月13日 下午3:15:13
	* @description 
	*/
	@Autowired
    private MyChannel sender;
	@Autowired
    private UserChannel usersender;
	
    @RequestMapping("/send1")
    public String send(){
        try {
            sender.output().send(MessageBuilder.withPayload("Hello World").build());
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    
    @RequestMapping("/senduser")
    public String senduser(){
        try {
        	User user = new User();
        	user.setName("zhoutianqi");
        	user.setPasword("111111");
        	usersender.output().send(MessageBuilder.withPayload(user).build());
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
