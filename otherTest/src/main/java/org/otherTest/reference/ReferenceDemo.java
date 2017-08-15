package org.otherTest.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
  
/** 
 * 强引用、软引用、弱引用、虚引用总结
 */  

public class ReferenceDemo {  
  
    private static ReferenceQueue<User> referenceQueue = new ReferenceQueue<User>();  
    private static final int size = 10;  
  
    public static void main(String[] args) {  
//        testSoftReference();  
//        testWeaKReference();  
        testPhantomReference();  
    }  
    
    public static void checkQueue(){  
        Reference<? extends User> reference = null; 
        while((reference = referenceQueue.poll())!=null){ 
//            System.out.println("In queue : "+reference.get()); 
        	System.out.println("In queue : "+reference); 
        }  
        /*Reference<? extends User> reference = referenceQueue.poll();  
        if(reference!=null){  
            System.out.println("In queue : "+reference.get());  
        }  */
    }  
  
    /**
     * 软引用测试
     */
    public static void testSoftReference()  
    {  
        Set<SoftReference<User>> softReferenceSet = new HashSet<SoftReference<User>>();  
        for (int i = 0; i < size; i++) {  
            SoftReference<User> ref = new SoftReference<User>(new User("Soft " + i), referenceQueue);  
            System.out.println("Just created: " + ref.get());  
            softReferenceSet.add(ref);  
        }  
        System.gc();  
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//        for (SoftReference<User> softReference : softReferenceSet) {
//        	User user = softReference.get();
//        	System.out.println(user);
//		}
        
        checkQueue();  
    }  
  
    /**
     * 弱引用测试
     */
    public static void testWeaKReference()  
    {  
        Set<WeakReference<User>> weakReferenceSet = new HashSet<WeakReference<User>>();  
        for (int i = 0; i < size; i++) {  
            WeakReference<User> ref = new WeakReference<User>(new User("Weak " + i), referenceQueue);  
            System.out.println("Just created: " + ref.get());
            weakReferenceSet.add(ref);  
        }  
        System.gc();  
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        checkQueue();  
    }  
  
    /**
     * 虚引用测试
     */
    public static void testPhantomReference()  
    {  
        Set<PhantomReference<User>> phantomReferenceSet = new HashSet<PhantomReference<User>>();  
        for (int i = 0; i < size; i++) {  
            PhantomReference<User> ref =  
                    new PhantomReference<User>(new User("Phantom " + i), referenceQueue);  
            System.out.println("Just created: " + ref.get());  // 无法通过虚引用获取其引用的对象，这里输出null
            
            phantomReferenceSet.add(ref);  
        }  
        System.gc();  
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        checkQueue();  
    }  
  

}  


class User {  
	  
    private String name;  
  
    public User()  
    {}  
  
    public User(String name)  
    {  
        this.name=name;  
    }  
  
    @Override  
    public String toString() {  
        return name;  
    }  
  
    public void finalize(){  
        System.out.println("Finalizing ... "+name);  
    }  
}  
