package com.hzw.java_learn.dubbo.client;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:dubbox-client.xml")
public class DubboDemoTest {
	
	@Autowired
	private DubboClientDemo dubboClientDemo;
	
	@Test
	public void test() {
		
		dubboClientDemo.sayMsg();
        	
	}

}
