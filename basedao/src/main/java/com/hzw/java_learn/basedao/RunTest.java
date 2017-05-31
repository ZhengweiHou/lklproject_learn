package com.hzw.java_learn.basedao;

public class RunTest extends Thread{
	@Override
    public void run() {
	   
	    super.run();
	    
	    while (true) {

	    	 try {
	 			Thread.sleep(500);
	 		} catch (InterruptedException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	    	System.out.println("1111111");
			
		}
	    
	    
	}
}
