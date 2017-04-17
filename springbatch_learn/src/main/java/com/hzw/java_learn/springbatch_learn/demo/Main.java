package com.hzw.java_learn.springbatch_learn.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

public class Main {
	public static void main(String[] args) {
		ApplicationContext  context = new ClassPathXmlApplicationContext("batchDemo.xml");
		
       SimpleJobLauncher launcher = new SimpleJobLauncher();  
       launcher.setJobRepository((JobRepository) context.getBean("jobRepository"));  
       launcher.setTaskExecutor(new SimpleAsyncTaskExecutor());  
       try {  
            launcher.run((Job) context.getBean("job1"), new JobParameters());  
       } catch (Exception e) {  
       e.printStackTrace();  
       }  
	}
}
