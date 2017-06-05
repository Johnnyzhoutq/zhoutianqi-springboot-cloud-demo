package com.zhoutianqi.kafka.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MsgSender {
	/**
	* @author zhoutianqi
	* @className MsgSender.java
	* @date 2017年6月5日 下午4:05:19
	* @description 
	*/
	@Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void send() {
        kafkaTemplate.send("hello-topic","testData-txt1");
        kafkaTemplate.send("hello-topic","testData-txt2");
    }
}
