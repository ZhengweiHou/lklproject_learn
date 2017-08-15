package org.otherTest.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;

/**
 * 弱引用
 * 
 * @author houzw
 *
 */
public class WeakReferenceTest {

	public static void main(String[] args) throws InterruptedException {
		B b = new B();
		WeakReference<B> wr = new WeakReference<B>(b);
//		b = null;		// 将B对象的强引用去掉
		System.gc();	// 调用GC  当B对象的强引用不存在时才会对B对象进行
		wr.get().say();
		
	}

}

class B {

	public void say() {
		System.out.println("身体健康！");
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("B 的 finalize 方法！");
	}

}
