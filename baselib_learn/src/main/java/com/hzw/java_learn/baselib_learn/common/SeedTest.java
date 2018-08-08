package com.hzw.java_learn.baselib_learn.common;

import java.util.*;

public class SeedTest
{
	public static void main(String[] args) {
		Random r1 = new Random(50);
		System.out.println("第一个种子为50的Random对象");
		System.out.println("r1.nextBoolean():\t" + r1.nextBoolean());
		System.out.println("r1.nextInt():\t\t" + r1.nextInt());
		System.out.println("r1.nextDouble():\t" + r1.nextDouble());
		System.out.println("r1.nextGaussian():\t" + r1.nextGaussian());
		System.out.println("---------------------------");
		Random r2 = new Random(50);
		System.out.println("第二个种子为50的Random对象");
		System.out.println("r2.nextBoolean():\t" + r2.nextBoolean());
		System.out.println("r2.nextInt():\t\t" + r2.nextInt());
		System.out.println("r2.nextDouble():\t" + r2.nextDouble());
		System.out.println("r2.nextGaussian():\t" + r2.nextGaussian());
		System.out.println("---------------------------");
		Random r3 = new Random(100);
		System.out.println("种子为100的Random对象");
		System.out.println("r3.nextBoolean():\t" + r3.nextBoolean());
		System.out.println("r3.nextInt():\t\t" + r3.nextInt());
		System.out.println("r3.nextDouble():\t" + r3.nextDouble());
		System.out.println("r3.nextGaussian():\t" + r3.nextGaussian());
	}
}

/*
第一个种子为50的Random对象
r1.nextBoolean():	true
r1.nextInt():		-1727040520
r1.nextDouble():	0.6141579720626675
r1.nextGaussian():	2.377650302287946
---------------------------
第二个种子为50的Random对象
r2.nextBoolean():	true
r2.nextInt():		-1727040520
r2.nextDouble():	0.6141579720626675
r2.nextGaussian():	2.377650302287946
---------------------------
种子为100的Random对象
r3.nextBoolean():	true
r3.nextInt():		-1139614796
r3.nextDouble():	0.19497605734770518
r3.nextGaussian():	0.6762208162903859
*/
