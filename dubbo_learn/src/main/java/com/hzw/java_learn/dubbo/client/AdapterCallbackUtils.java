package com.hzw.java_learn.dubbo.client;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Value;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.hzw.java_learn.dubbo.service.DubboServiceDemo;

/**
 * adapter dubbo 服务工具
 * @author houzw
 */
public class AdapterCallbackUtils {
    // 当前应用的信息
    private static ApplicationConfig application = new ApplicationConfig();
    // 注册中心信息缓存
    private static Map<String, RegistryConfig> registryConfigCache = new ConcurrentHashMap<>();
    // 各个业务方的ReferenceConfig缓存
    private static Map<String, ReferenceConfig<DubboServiceDemo>> referenceCache = new ConcurrentHashMap<>();

    private static String SERVICE_SUFF = "Service";
    
    private static String address;
    
    private static String group;
    
    private static Integer port;
    
    private static String version;
    
    static {
        application.setName("AdapterCallback");
    }

    /**
     * 获取注册中心信息
     * 
     * @param address
     *            zk注册地址
     * @param group
     *            dubbo服务所在的组
     * @return
     */
    private static RegistryConfig getRegistryConfig(String address, String group, Integer port, String version) {
        String key = address + "-" + group + "-" + version;
        RegistryConfig registryConfig = registryConfigCache.get(key);
        if (null == registryConfig) {
            registryConfig = new RegistryConfig();
            registryConfig.setAddress(address);
            registryConfig.setGroup(group);
//            registryConfig.setPort(port);

            registryConfigCache.put(key, registryConfig);
        }
        return registryConfig;
    }

    /**
     * 获取服务的代理对象
     * 
     * @param business
     * @param address
     * @param group
     * @return
     */
    private static ReferenceConfig<DubboServiceDemo> getReferenceConfig(String business, String address,
            String group,  Integer port, String version) {
        String referenceKey = business;
        ReferenceConfig<DubboServiceDemo> referenceConfig = referenceCache.get(referenceKey);
        if (null == referenceConfig) {
            referenceConfig = new ReferenceConfig<>();
            referenceConfig.setApplication(application);
            referenceConfig.setRegistry(getRegistryConfig(address, group, port, version));
            referenceConfig.setInterface(DubboServiceDemo.class);
            referenceConfig.setVersion(version);
            referenceConfig.setId(business+SERVICE_SUFF);
            
            referenceCache.put(referenceKey, referenceConfig);
        }
        return referenceConfig;
    }

    /**
     * 初始化数据
     * 
     * @param business
     * @param address
     * @param group
     * @param version
     */
    public static void init(String address, String group, Integer port, String version) {
//        getReferenceConfig(business, address, group, port, version);
    	setAddress(address);
    	setGroup(group);
    	setPort(port);
    	setVersion(version);
    }
    
    /**
     * 获取远程服务实例
     * 
     * @param business
     * @return
     */
    public static DubboServiceDemo getInstance(String business){
    	ReferenceConfig<DubboServiceDemo> reference = getReferenceConfig(business, address, group, port, version);
        if (null != reference) {
        	DubboServiceDemo callbackService = reference.get();
            if (null != callbackService) {
                return callbackService;
            }
        }
        return null;
    }


	public static String getSERVICE_SUFF() {
		return SERVICE_SUFF;
	}

	public static void setSERVICE_SUFF(String sERVICE_SUFF) {
		SERVICE_SUFF = sERVICE_SUFF;
	}

	public static String getAddress() {
		return address;
	}

	public static void setAddress(String address) {
		AdapterCallbackUtils.address = address;
	}

	public static String getGroup() {
		return group;
	}

	public static void setGroup(String group) {
		AdapterCallbackUtils.group = group;
	}

	public static Integer getPort() {
		return port;
	}

	public static void setPort(Integer port) {
		AdapterCallbackUtils.port = port;
	}

	public static String getVersion() {
		return version;
	}

	public static void setVersion(String version) {
		AdapterCallbackUtils.version = version;
	}
    
    

//    /**
//     * 调用远程服务
//     * 
//     * @param business
//     * @param address
//     * @param group
//     * @param version
//     * @return
//     */
//    public static boolean invoke(String business, DubboServiceDemo dto) {
//        ReferenceConfig<DubboServiceDemo> reference = getReferenceConfig(business, null, null, null);
//        if (null != reference) {
//        	DubboServiceDemo callbackService = reference.get();
//            if (null != callbackService) {
////                return callbackService.callback(dto);
//            }
//        }
//        return false;
//    }
    
    
}
