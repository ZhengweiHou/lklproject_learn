package com.hzw.java_learn.schedule_learn;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoJobTask {
	
	public void doJob(){
		
		System.out.println("-------------------执行任务"+new Date()+"--------------------");
	}
}
