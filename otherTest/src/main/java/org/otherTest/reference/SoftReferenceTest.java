package org.otherTest.reference;

import java.lang.ref.SoftReference;

/**
 * 软引用
 * @author houzw
 *
 */
public class SoftReferenceTest {
	public static void main(String[] args) {
		A a = new A();
		SoftReference<A> ar = new SoftReference<A>(a);
		a = null;
		ar.get().say();
		
	}
}

class A {

	public void say() {
		System.out.println("身体健康！");
	}

}