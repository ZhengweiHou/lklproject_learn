package com.hzw.java_learn.dubbo.service.impl;

import com.hzw.java_learn.dubbo.service.DubboServiceDemo;
import org.springframework.stereotype.Service;

@Service
public class DubboServiceDemoImpl implements DubboServiceDemo{

	public String sayHello() {
		System.out.println("收到客户端请求。。。");
		return "Hello Dubbo and Zookeeper！";
	}

}
