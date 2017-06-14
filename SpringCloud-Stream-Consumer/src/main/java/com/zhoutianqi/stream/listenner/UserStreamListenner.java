package com.zhoutianqi.stream.listenner;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.zhoutianqi.stream.consumer.UserChannel;
import com.zhoutianqi.stream.entity.User;

@Component
@EnableBinding(UserChannel.class)
public class UserStreamListenner {
	/**
	* @author zhoutianqi
	* @className StreamListenner.java
	* @date 2017年6月13日 下午3:49:15
	* @description 
	*/
	@StreamListener(UserChannel.INPUT)
    public void receive(Message<User> message){
        System.out.println(message);
        System.out.println(message.getPayload());
        System.out.println(message.getPayload().getName()+" : "+message.getPayload().getPasword());
    }

}
