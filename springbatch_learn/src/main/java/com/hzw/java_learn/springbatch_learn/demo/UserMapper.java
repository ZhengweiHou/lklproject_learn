package com.hzw.java_learn.springbatch_learn.demo;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class UserMapper implements FieldSetMapper<User> {

	public User mapFieldSet(FieldSet fieldSet) throws BindException {
		User user = new User();
		user.setName(fieldSet.readString(0));
		user.setAge(fieldSet.readInt(1));
		return user;
	}

}