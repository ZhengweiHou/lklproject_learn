package com.hzw.java_learn.javabase.generic;

import java.util.ArrayList;
import java.util.List;

public class 通配符 {
	
	public static void main(String[] args) {
		
		List<Student> students = new ArrayList<Student>();
		
		
		students.add(new Zhangsan());
		students.add(new Lisi());
		
		Student.test1(students);
		Student.test2(students);
		Student.test3(students);
		
	}
}

abstract class Student{
	public void talk(){
		System.out.println("我是" + this.getClass().getSimpleName());
	}
	
	public static void test1(List<?> students){
		for (Object object : students) {
			try {
				object.getClass().getMethod("talk").invoke(object);
			} catch (Exception e) {System.out.println("hehe");}
		}
	}
	
	// 受限通配符 ? extends xxx
	public static void test2(List<? extends Student> students){
		for (Student student : students) {student.talk();}
	}
	public static <T extends Student> void test3(List<T> students){
		for (Student student : students) {student.talk();}
	}
}
class Zhangsan extends Student{}
class Lisi extends Student{}
