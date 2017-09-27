package com.hzw.java_learn.javadesignpatterns.proxypattern.pattern3;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class WangPo implements MethodInterceptor {

	// 维护目标对象
	private Object womenTarget;

	public WangPo(Object womenTarget) {
		this.womenTarget = womenTarget;
	}

	// 给目标对象创建一个代理对象
	public Object getProxyInstance() {
		// 工具类
		Enhancer en = new Enhancer();
		// 设置父类
		en.setSuperclass(womenTarget.getClass());
		// 设置回调函数
		en.setCallback(this);
		// 创建子类（代理对象）
		return en.create();
	}

	public Object intercept(Object arg0, Method method, Object[] arg2,
			MethodProxy arg3) throws Throwable {

		// 真正操作之前可以进行其他处理
		// TODO do some thing brfore
		System.out.println("王婆开始传话..");
		
		Object returnValue = method.invoke(womenTarget, arg2);
		
		// 真正操作之后可以进行其他处理
		// TODO do some thing after
		System.out.println("王婆传话结束..");
		

		return returnValue;

	}

}
