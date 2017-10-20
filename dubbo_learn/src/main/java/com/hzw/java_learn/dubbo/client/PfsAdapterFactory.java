package com.hzw.java_learn.dubbo.client;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.hzw.java_learn.dubbo.service.DubboServiceDemo;

public class  PfsAdapterFactory{

	// 当前应用的信息
	private static ApplicationConfig application = new ApplicationConfig();

	// 注册中心信息缓存
	private static Map<String, RegistryConfig> registryConfigCache = new ConcurrentHashMap<>();

	// 各个业务方的ReferenceConfig缓存
	private static Map<String, ReferenceConfig> referenceCache = new ConcurrentHashMap<>();
	

	private Integer timeout = 3000;
	
	private Boolean referenceCheak = false;
	
	private String protocol = "zookeeper";
	
	static{
		application.setName("PFSAdapter");
	}
	
	public void setTimeOut(Integer timeout){
		this.timeout = timeout;
	}
	
	public void setApplicationName(String applicationName){
		application.setName(applicationName);
	}

	public RegistryConfig getRegistryConfig(String address, String group) {
		String key = address + "-" + group;
		RegistryConfig registryConfig = registryConfigCache.get(key);
		if (null == registryConfig) {
			registryConfig = new RegistryConfig();
			registryConfig.setAddress(address);
			registryConfig.setGroup(group);
			registryConfig.setProtocol(protocol);
			registryConfigCache.put(key, registryConfig);
		}
		return registryConfig;
	}
	
	private ReferenceConfig<DubboServiceDemo> getReferenceConfig(String business, String address,
            String group, String version) {
		String key = DubboServiceDemo.class.getName()+"-"+address+"-"+group+"-"+business+version;
		ReferenceConfig<DubboServiceDemo> referenceConfig = referenceCache.get(key);
		if(null == referenceConfig){
			ConsumerConfig consumerConfig = new ConsumerConfig();
			consumerConfig.setTimeout(timeout);
			
			referenceConfig = new ReferenceConfig<DubboServiceDemo>();
			referenceConfig.setApplication(application);
			referenceConfig.setRegistry(getRegistryConfig(address, group));
			referenceConfig.setConsumer(consumerConfig);
			referenceConfig.setInterface(DubboServiceDemo.class.getName());
			referenceConfig.setCheck(referenceCheak);
			
			referenceConfig.setId(key);
			referenceConfig.setVersion(business+"."+version);
			
			referenceCache.put(key, referenceConfig);
		}
		
		return referenceConfig;
	}
	
	public DubboServiceDemo getServiceInstance(String business, String address,
            String group, String version){
		ReferenceConfig<DubboServiceDemo> reference = getReferenceConfig(business, address, group, version);
		if(null != reference){
			DubboServiceDemo temp = reference.get();
			if(null != temp){
				return temp;
			}
		}
		
		return null;
	}
	
}
