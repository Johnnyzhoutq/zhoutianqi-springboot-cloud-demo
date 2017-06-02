package com.zhoutianqi.mq.Sender;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.stereotype.Component;

import com.zhoutianqi.mq.entity.Message;
@Component
public class MessageSender {
	/**
	* @author zhoutianqi
	* @className MessageSender.java
	* @date 2017年6月2日 下午3:37:04
	* @description 
	*/
	@Autowired
	private RabbitMessagingTemplate rabbitMessagingTemplate;
	@Autowired
	private MappingJackson2MessageConverter mappingJackson2MessageConverter;

	public void sendToRabbitmq(Message host, String extraContent){
		
		this.rabbitMessagingTemplate.setMessageConverter(this.mappingJackson2MessageConverter);

		Map<String, Object> header = new HashMap<>();
		header.put("extraContent", extraContent);

		this.rabbitMessagingTemplate.convertAndSend("exchange", "queue.message", host, header);
		System.out.println("Send a customized object message to [queue.message] by RabbitMessagingTemplate");
	}
	
	public void sendListToRabbitmq(List<Message>  listHost,  String extraContent){
		
		this.rabbitMessagingTemplate.setMessageConverter(this.mappingJackson2MessageConverter);
		
		Map<String, Object> header = new HashMap<>();
		header.put("extraContent", extraContent);
		this.rabbitMessagingTemplate.convertAndSend("exchange", "queue.messages", listHost, header);
		System.out.println("Send a customized object list message to [queue.message] by RabbitMessagingTemplate");
	}
}
