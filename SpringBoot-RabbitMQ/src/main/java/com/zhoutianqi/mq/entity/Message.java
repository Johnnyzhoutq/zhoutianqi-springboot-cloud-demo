package com.zhoutianqi.mq.entity;

public class Message {

	private String text;
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(String text){
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
