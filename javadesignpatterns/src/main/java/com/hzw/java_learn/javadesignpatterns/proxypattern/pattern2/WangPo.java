package com.hzw.java_learn.javadesignpatterns.proxypattern.pattern2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class WangPo implements InvocationHandler {
	
	private Object women;
	
	public Object bind(Object women){
		this.women = women;
		System.out.println("王婆帮" + women.getClass().getSimpleName() + "传话");
		return Proxy.newProxyInstance(women.getClass().getClassLoader(), women.getClass().getInterfaces(), this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		// 真正操作之前可以进行其他处理
		// TODO do some thing brfore
		
		Object returnValue = method.invoke(women, args);
		
		// 真正操作之后可以进行其他处理
		// TODO do some thing after
		
		return returnValue;
	}

}
