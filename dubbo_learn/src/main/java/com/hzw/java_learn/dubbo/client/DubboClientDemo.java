package com.hzw.java_learn.dubbo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzw.java_learn.dubbo.service.DubboServiceDemo;

@Service
public class DubboClientDemo {
	@Autowired
	private DubboServiceDemo dubboServiceDemoClient;
	
	public void sayMsg(){
		String msg = dubboServiceDemoClient.sayHello();
		System.out.println("get dubbo msg:" + msg);
	}

}
