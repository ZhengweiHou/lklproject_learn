package com.hzw.java_learn.activity_learn.myProcess1;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service("serviceTask1")
public class ServiceTask1 implements JavaDelegate{
	private Expression field1;
	
	public void execute(DelegateExecution execution) throws Exception {
		String field1Str = (String) field1.getValue(execution);
		System.out.println("serviceTask1 --- do");
		System.out.println(field1Str);
		execution.setVariable("var", field1Str);
	}

}
