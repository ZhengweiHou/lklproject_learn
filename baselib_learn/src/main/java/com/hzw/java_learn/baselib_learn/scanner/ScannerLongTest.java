package com.hzw.java_learn.baselib_learn.scanner;

import java.util.Scanner;

public class ScannerLongTest {

	public static void main(String[] args) {
		
		// System.in代表标准输入，就是键盘输入
		Scanner sc = new Scanner(System.in);
		// 增加下面一行将只把回车作为分隔符
		while(sc.hasNextLong()){
			// 输出输入项
			System.out.println("键盘输入的内容是:" + sc.nextLong());
		}
	}
	
}
