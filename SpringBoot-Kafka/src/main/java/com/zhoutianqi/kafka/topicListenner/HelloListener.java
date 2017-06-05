package com.zhoutianqi.kafka.topicListenner;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class HelloListener {
	/**
	* @author zhoutianqi
	* @className HelloListener.java
	* @date 2017年6月5日 下午4:17:51
	* @description 
	*/
	@KafkaListener(topics = {"hello-topic"})
    public void testListener(ConsumerRecord<?, ?> record) {
		//Optional 在java 8中才支持，本地环境1.7，见谅
       /* Optional<?> messages = Optional.ofNullable(record.value());
        if (messages.isPresent()) {
            Object msg = messages.get();
            System.out.println("  this is the testTopic send message: " + msg);
        }*/
		System.out.println("KafkaListener:->"+record.value());
    }
}
