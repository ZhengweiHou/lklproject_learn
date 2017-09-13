package com.hzw.java_learn.activity_learn.myProcess1;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service("serviceTask2")
public class ServiceTask2 implements JavaDelegate{
	public void execute(DelegateExecution execution) throws Exception {
		String var = (String) execution.getVariable("var");
		System.out.println("serviceTask2 --- do     var="+var);
		execution.setVariable("var", "serviceTask2");
	}

}
