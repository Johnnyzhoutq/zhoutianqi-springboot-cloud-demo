package com.zhoutianqi.stream.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;


@Component
public interface MyChannel {
	/**
	* @author zhoutianqi
	* @className MyChannel1.java
	* @date 2017年6月13日 下午3:12:41
	* @description @Output注解代表这是一个输出通道，而通道名就是我们定义的test，一个接口中可以定义多个输入和输出通道。
	* 实际上SCS本身提供了三个预定义接口通道，即Source.class单向输出通道，Sink.class单向输入通道，以及继承了它们两个的
	* Processor.class，你可以在源码org.springframework.cloud.stream.messaging包中找到它们。但它们都只是简
	* 单示例，真正开发时我们肯定还是要自定义接口作为通道；
	*/
	String OUTPUT = "test";

    @Output(OUTPUT)
    MessageChannel output();
}
