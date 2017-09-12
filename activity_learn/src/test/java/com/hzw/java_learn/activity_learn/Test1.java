package com.hzw.java_learn.activity_learn;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class Test1 {

	@Autowired
	ProcessEngine processEngine;
	
	@Autowired
	RepositoryService repositoryService;
	
	@Autowired
	HZWTest hZWTest;
	
	@Test
	public void deployProc(){
		hZWTest.show();
		
		Deployment deployment = repositoryService.createDeployment()
		.name("hzwtest1")  
		.deploy();
		System.out.println(deployment.getId());
		System.out.println(deployment.getName());
	}

}
