package com.zhoutianqi.stream.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface UserChannel {
	/**
	* @author zhoutianqi
	* @className Receiver1.java
	* @date 2017年6月13日 下午3:47:18
	* @description 
	*/
	String INPUT = "usertest";

    @Input(INPUT)
    SubscribableChannel input();
}
