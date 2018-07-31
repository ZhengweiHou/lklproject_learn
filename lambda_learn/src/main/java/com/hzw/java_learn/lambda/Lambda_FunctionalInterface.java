package com.hzw.java_learn.lambda;


/**
 *	函数式接口 - lambada表达式
 */
public class Lambda_FunctionalInterface {
	
	public static void main(String[] args) {
		HzwInterface interfaceTest = () -> {System.out.println("小霸王");};
		interfaceTest.test();
	}
}

@FunctionalInterface
interface HzwInterface{
	public void test();
}



