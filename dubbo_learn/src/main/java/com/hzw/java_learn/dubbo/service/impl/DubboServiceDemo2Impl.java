package com.hzw.java_learn.dubbo.service.impl;

import com.hzw.java_learn.dubbo.service.DubboServiceDemo;

import org.springframework.stereotype.Service;

@Service("BService")
public class DubboServiceDemo2Impl implements DubboServiceDemo{

	public String sayHello() {
		System.out.println("收到客户端请求 Demo2。。。");
		
		int i=2;

		if(i==2){

//			throw new RuntimeException();  //直接手动抛出异常

		}
		System.out.println("异常后");
		
		
		

		
		return "Hello Dubbo and Zookeeper Demo2！";
	}

}
