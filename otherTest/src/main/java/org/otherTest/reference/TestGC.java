package org.otherTest.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * 
 * GC垃圾回收测试
 * @author houzw
 *
 */
public class TestGC {
	
	public static ReferenceQueue req = new ReferenceQueue();
	
	public static void main(String[] args) {
		
		test();
		
	}
	
	
	public static void test(){
		GCA a1 = new GCA("a1");
		GCA a2 = new GCA("a2");
		a1.gca = a2;
		a2.gca = a1;
		
//		WeakReference<GCA> wr1 = new WeakReference<GCA>(a1,req);
//		WeakReference<GCA> wr2 = new WeakReference<GCA>(a2,req);
		
		PhantomReference<GCA> pr1 = new PhantomReference<GCA>(a1, req);
		PhantomReference<GCA> pr2 = new PhantomReference<GCA>(a2, req);
		
		checkQueue(req);
		
		a1 = null;
		a2 = null;
		
		System.gc();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		checkQueue(req);
	}
	
	public static void checkQueue(ReferenceQueue referenceQueue){  
		System.out.println("checkQueue:");
	    Reference<? extends GCA> reference = null; 
	    while((reference = referenceQueue.poll())!=null){ 
	    	System.out.println("In queue : "+reference); 
	    } 
	} 
	
}





class GCA {
	public GCA gca = null;
	
	private String name = null;
	
	public GCA(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize name:"+name+"  gca.name:"+gca.getName());
	}
}