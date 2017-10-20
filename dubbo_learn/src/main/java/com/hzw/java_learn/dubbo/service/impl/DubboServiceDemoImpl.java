package com.hzw.java_learn.dubbo.service.impl;

import org.springframework.stereotype.Service;

import com.hzw.java_learn.dubbo.service.DubboServiceDemo;

@Service("AService")
public class DubboServiceDemoImpl implements DubboServiceDemo{

	public String sayHello() {
		System.out.println("收到客户端请求。。。");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("sleep after");
		

		return "Hello Dubbo and Zookeeper！";
	}

}
