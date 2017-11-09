package com.hzw.java_learn.rabbitmq.service;

import org.springframework.stereotype.Service;

@Service("rabbitTestQueueListener")
public class RabbitTestQueueListener {
	
	public void handleRequest(String msg){
		System.out.println(msg);
	}
	
}
