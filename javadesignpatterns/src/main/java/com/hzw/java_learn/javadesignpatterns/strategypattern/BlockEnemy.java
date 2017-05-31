package com.hzw.java_learn.javadesignpatterns.strategypattern;

/**
 * 孙夫人断后，挡住追兵
 */
public class BlockEnemy implements IStrategy {
	public void operate() {
		System.out.println("孙夫人断后，挡住追兵");
	}
}
