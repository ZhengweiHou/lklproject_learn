package org.otherTest.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用
 * 
 * @author houzw
 */
public class PhantomReferenceTest {
	public static void main(String[] args) {
		C c = new C();
		ReferenceQueue rq = new ReferenceQueue();
		PhantomReference<C> pr = new PhantomReference<C>(c, rq);
		// 取出虚引用所引用的对象，并不能通过虚引用获取被引用的对象，输出null
		System.out.println(pr.get());
		c = null;
		System.out.println(pr.get());
		System.gc();
		System.runFinalization();
		// 当虚引用引用的对象被回收后，虚引用对象就被添加到其关联的引用队列中
		System.out.println(rq.poll() == pr);
	}
}

class C {
	public void say() {
		System.out.println("身体健康！");
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("C 的 finalize 方法！");
	}
}
