package com.hzw.java_learn.javadesignpatterns.proxypattern.pattern3;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class WangPo implements MethodInterceptor {

	// 维护目标对象
	private Object target;

	public WangPo(){};
	
	public WangPo(Object target) {
		this.target = target;
	}

	// 给目标对象创建一个代理对象
	public Object getProxyInstance() {
		
		// 直接创建
//		return Enhancer.create(target.getClass(), this);
		
		// 工具类
		Enhancer en = new Enhancer();
		// 设置父类
		en.setSuperclass(target.getClass());
		// 设置回调函数
		en.setCallback(this);
		// 创建子类（代理对象）
		return en.create();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getProcxyInstance(Class<T> clazz){
		return (T) Enhancer.create(clazz, this);
	}

	public Object intercept(Object arg0, Method method, Object[] arg2,
			MethodProxy proxy) throws Throwable {

		// 真正操作之前可以进行其他处理
		// TODO do some thing brfore
		System.out.println("王婆开始传话..");
		Object returnValue = null;
		
		returnValue = proxy.invokeSuper(arg0, arg2); // 方式1 -- 代理类不用再维护目标对象
		
		if(target != null){
			returnValue = method.invoke(target, arg2); // 方式2
		}else{
			System.out.println("维护对象【target】为空");
		}
		// 方式1，则代理类不用再维护目标对象
		
		// 真正操作之后可以进行其他处理
		// TODO do some thing after
		System.out.println("王婆传话结束..");
		

		return returnValue;

	}

}
