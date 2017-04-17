package com.hzw.java_learn.springbatch_learn.demo;

import org.springframework.batch.item.ItemProcessor;

public class MessageProcessor implements ItemProcessor<User, String> {

	public String process(User user) throws Exception {
		
		if(user.getAge() > 10){
			return "name" + user.getName() + "age:" + user.getAge();
		}
		return null;
	}
	
}