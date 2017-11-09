package com.hzw.java_learn.rabbitmq.main;

import java.io.IOException;

import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceMain {

	public static void main(String[] args) throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("mq-service.xml");
		
		System.out.println("======启动成功======");
		System.in.read();

	}
	
	
	public void serviceDo(){
		SimpleMessageListenerContainer a = new SimpleMessageListenerContainer();
	}

}
