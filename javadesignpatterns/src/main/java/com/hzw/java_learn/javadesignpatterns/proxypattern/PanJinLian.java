package com.hzw.java_learn.javadesignpatterns.proxypattern;

/**
 * 定一个潘金莲是什么样的人
 */
public class PanJinLian implements KindWomen {
	public void happyWithMan() {
		System.out.println("潘金莲在和男人做那个.....");
	}

	public void makeEyesWithMan() {
		System.out.println("潘金莲抛媚眼");
	}
}
