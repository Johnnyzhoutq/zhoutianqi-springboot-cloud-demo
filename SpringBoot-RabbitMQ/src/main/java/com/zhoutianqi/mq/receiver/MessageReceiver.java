package com.zhoutianqi.mq.receiver;

import java.util.List;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.zhoutianqi.mq.entity.Message;

@Component
public class MessageReceiver {
	/**
	* @author zhoutianqi
	* @className MessageReceiver.java
	* @date 2017年6月2日 下午3:38:39
	* @description 
	*/
	@RabbitListener(queues = "queue.message")
	@RabbitHandler
	public void receiveMessage(Message message) {
		System.out.println("queue.message-> Received message<" + message.getText() + ">");
	}
	
	@RabbitListener(queues = "queue.messages")
	@RabbitHandler
	public void receiveMessages(List<Message>  listHost) {
		System.out.println("queue.messages-> Received list message number<" + listHost.size() + ">");
	}
}
