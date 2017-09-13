package com.hzw.java_learn.activity_learn.myProcess1;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.delegate.Expression;
import org.springframework.stereotype.Service;

@Service("flow2")
public class Flow2 implements ExecutionListener{
	private static final long serialVersionUID = 1L;
	private Expression field1;
	
	public void notify(DelegateExecution execution) throws Exception {
		String field1Str = (String) field1.getValue(execution);
		System.out.println("flow2 --- do");
		System.out.println(field1Str);
		execution.setVariable("var", field1Str);
	}

}
