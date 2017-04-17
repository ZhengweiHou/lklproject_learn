package com.hzw.java_learn.springbatch_learn.demo;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class MessageWriter implements ItemWriter<String>{

	public void write(List<? extends String> items) throws Exception {
		System.out.println("所有的年纪大于10的如下");
		for (String string : items) {
			System.out.println(string);
		}
	}

}
