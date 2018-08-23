package com.hzw.java_learn.javabase.io.file;

import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		File file = new File(".");
		
		System.out.println(file.getName());
		System.out.println(file.getAbsoluteFile());
		System.out.println(file.getAbsoluteFile().getParent());
	}
}
