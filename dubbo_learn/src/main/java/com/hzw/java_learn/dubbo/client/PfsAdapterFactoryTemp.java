package com.hzw.java_learn.dubbo.client;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.hzw.java_learn.dubbo.service.DubboServiceDemo;

public class  PfsAdapterFactoryTemp <T>{

	// 当前应用的信息
	private static ApplicationConfig application = new ApplicationConfig();

	// 注册中心信息缓存
	private static Map<String, RegistryConfig> registryConfigCache = new ConcurrentHashMap<>();

	// 各个业务方的ReferenceConfig缓存
	private static Map<String, ReferenceConfig> referenceCache = new ConcurrentHashMap<>();
	

	private Integer timeout = 3000;
	
	private Boolean referenceCheak = false;
	
	private String protocol = "zookeeper";
	
	private Class<T> clazz;
	
	static{
		application.setName("PFSAdapter");
	}

	private PfsAdapterFactoryTemp(){
		super();
	};
	
	public PfsAdapterFactoryTemp(T t){
		super();
		this.clazz = (Class<T>) t.getClass();
	};
	
//	public PfsAdapterFactory<T> bind(Class<T> clazz){
//		this.clazz = clazz;
//		return new PfsAdapterFactory<T>(); 
//		}
	
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
	
	private ReferenceConfig<T> getReferenceConfig(String business, String address,
            String group, String version) {
		String key = clazz.getName()+"-"+address+"-"+group+"-"+business+version;
		ReferenceConfig<T> referenceConfig = referenceCache.get(key);
		if(null == referenceConfig){
			ConsumerConfig consumerConfig = new ConsumerConfig();
			consumerConfig.setTimeout(timeout);
			
			referenceConfig = new ReferenceConfig<T>();
			referenceConfig.setApplication(application);
			referenceConfig.setRegistry(getRegistryConfig(address, group));
			referenceConfig.setConsumer(consumerConfig);
			referenceConfig.setInterface(clazz.getName());
			referenceConfig.setCheck(referenceCheak);
			
			referenceConfig.setId(key);
			referenceConfig.setVersion(business+"."+version);
			
			referenceCache.put(key, referenceConfig);
		}
		
		return referenceConfig;
	}
	
	public T getServiceInstance(String business, String address,
            String group, String version){
		ReferenceConfig<T> reference = getReferenceConfig(business, address, group, version);
		if(null != reference){
			T temp = reference.get();
			if(null != temp){
				return temp;
			}
		}
		
		return null;
	}
	
}
