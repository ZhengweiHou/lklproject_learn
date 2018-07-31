package com.hzw.java_learn.lambda;

/**
 * lambda - 方法引用
 * @author houzw
 *
 */
public class Lambda_MethodRefer {
	public static void main(String[] args) {
		// 1=======================
		HzwMethodRefer methodRefer_1 = a -> Integer.valueOf(a);
		System.out.println(methodRefer_1.test("123"));
		HzwMethodRefer methodRefer_2 = Integer::valueOf;
		System.out.println(methodRefer_2.test("123"));
		
		// 2=======================
		// 引用特定对象的实例方法（调用String对象的indexOf方法）
		HzwMethodRefer methodRefer_3 = from -> "123".indexOf(from);
		System.out.println(methodRefer_3.test("2"));
		HzwMethodRefer methodRefer_4 = "123"::indexOf;
		System.out.println(methodRefer_4.test("2"));
		
		// 3=======================
		// 引用某类对象的实例方法
		HzwMethodRefer_I methodRefer_I = (a,b,c) -> a.substring(b, c);
		System.out.println(methodRefer_I.test("abcdefg", 2, 5));
		
		HzwMethodRefer_I methodRefer_I_2 = String::substring;
		
	}
}

@FunctionalInterface
interface HzwMethodRefer {
	public Integer test(String from);
}

@FunctionalInterface
interface HzwMethodRefer_I {
	public String test(String a, int b, int c);
}