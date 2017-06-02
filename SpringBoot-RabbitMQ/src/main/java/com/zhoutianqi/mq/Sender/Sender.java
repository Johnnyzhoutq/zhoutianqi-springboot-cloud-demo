package com.zhoutianqi.mq.Sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
/**
 * @author zhoutianqi
 * @create 2017.6.2
 */
@Component
public class Sender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String context = "hello " + new Date();
		System.out.println("This is a Sender : " + context);
		this.rabbitTemplate.convertAndSend("hello", context);
	}

}