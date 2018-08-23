package com.hzw.java_learn.javabase.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class Learn1 {
	public static void main(String[] args) {
		
		AInt<String> a1 = new AImpl<Integer>();
		a1.showClass("String");
		a1.showClass();
		
	}
}

/**
 * 接口
 * @author houzw
 * @param <T>
 */
interface AInt<T>{
	public void showClass(T entity);
	public void showClass();
}

/**
 * 父类
 * @author houzw
 * @param <G>
 */
abstract class APar<G>{
	public void parShowclass(){
		System.out.println("父类方法输出");
		Class c = this.getClass();
		
		// 获取继承父类中的泛型类型,子类继承调用 
		Type t = c.getGenericSuperclass(); 
		System.out.println(t);
		if (t instanceof ParameterizedType) {
			Type[] p = ((ParameterizedType) t).getActualTypeArguments();
			System.out.println(Arrays.toString(p));
        }
	}
}

/**
 * 接口的实现类
 * @author houzw
 * @param <E>
 */
class AImpl<E> extends APar<Integer> implements AInt<String>{
	
	public AImpl(){
		System.out.println("子类构造器输出======");
		Class c = this.getClass();
		
		// 获取实现的接口中的泛型类型数组
		Type[] tl = c.getGenericInterfaces(); 
		Type t = tl[0];
		System.out.println(t);
		if (t instanceof ParameterizedType) {
			Type[] p = ((ParameterizedType) t).getActualTypeArguments();
			System.out.println(Arrays.toString(p));
        }
		
	}

	//	 实现接口时指定了接口的泛型类型,则接口中的所有泛型参数全部被替换	
	//	String => T	则 showClass(String entity) => showClass(T entity)
	public void showClass(String entity) {
		// TODO Auto-generated method stub
	}

	public void showClass() {
		 this.parShowclass(); // 调用父类的方法
		
	}
	
	
	
}