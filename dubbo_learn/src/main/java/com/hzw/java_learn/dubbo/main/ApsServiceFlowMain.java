package com.hzw.java_learn.dubbo.main;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApsServiceFlowMain {

	public static void main(String[] args) throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("dubbox-service.xml");
		
		System.out.println("======启动成功======");
		System.in.read();

	}

}
