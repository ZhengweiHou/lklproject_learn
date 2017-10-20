package com.hzw.java_learn.dubbo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.hzw.java_learn.dubbo.service.DubboServiceDemo;

@Service
public class DubboClientDemo {
	@Autowired
	private DubboServiceDemo dubboServiceDemoClient;
	
    @Value("#{zookeeper_address}")
	private static String zookeeper_address;
    
    @Value("#{env['dubbo_port']}")
    private static Integer dubbo_port;
    
    @Value("#{env['zk_group']}")
    private static String zk_group;
    
    @Value("#{env['service_version']}")
    private static String service_version;
	
	public void sayMsg(){
		PfsAdapterFactory factory = new PfsAdapterFactory();
		DubboServiceDemo service = factory.getServiceInstance("B", "192.168.32.131:2181", "hzw", "1.0.0");
		service.sayHello();
	}
	
	
	public void sayMsg2(){
		
		ApplicationConfig application = new ApplicationConfig();
		application.setName("adapterTest");
		
		ConsumerConfig consumerConfig = new ConsumerConfig();
		consumerConfig.setRetries(0);
		consumerConfig.setCheck(false);
		consumerConfig.setTimeout(3000);
		
		RegistryConfig registryConfig = new RegistryConfig();
		registryConfig.setId("hzwRegistry");
		registryConfig.setAddress("192.168.32.131:2181");
		registryConfig.setProtocol("zookeeper");
		registryConfig.setGroup("hzw");
		
		ReferenceConfig<DubboServiceDemo> referenceConfig = new ReferenceConfig<DubboServiceDemo>();
		referenceConfig.setInterface(DubboServiceDemo.class.getName());
		referenceConfig.setVersion("1.0.0");
		referenceConfig.setCheck(false);
		referenceConfig.setId("dubboServiceDemoClient");
		
		referenceConfig.setApplication(application);
		referenceConfig.setRegistry(registryConfig);
		referenceConfig.setConsumer(consumerConfig);
		
		DubboServiceDemo duDemo = referenceConfig.get();
		
		duDemo.sayHello();
		
		
		
	}
	
    public void sayMsg3(){
		String msg = dubboServiceDemoClient.sayHello();
		System.out.println("get dubbo msg:" + msg);
    }
	
	
	
	
	

}
