package com.zhoutianqi.stream.listenner;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.zhoutianqi.stream.consumer.MyChannel;

@Component
@EnableBinding(MyChannel.class)
public class StreamListenner {
	/**
	* @author zhoutianqi
	* @className StreamListenner.java
	* @date 2017年6月13日 下午3:49:15
	* @description 
	*/
	@StreamListener(MyChannel.INPUT)
    public void receive(Message<String> message){
        System.out.println(message);
        System.out.println(message.getPayload());
    }

}
