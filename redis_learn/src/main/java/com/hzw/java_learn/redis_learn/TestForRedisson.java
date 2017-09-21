//package com.hzw.java_learn.redis_learn;
//
//import java.util.Queue;
//import java.util.Set;
//import java.util.concurrent.ConcurrentMap;
//
//import org.redisson.Redisson;
//import org.redisson.api.RExecutorService;
//import org.redisson.api.RLock;
//import org.redisson.api.RMap;
//import org.redisson.config.Config;
//
//public class TestForRedisson {
//
//	public static void main(String[] args) {  
//        // 1.初始化  
//        Config config = new Config();  
//        config.setConnectionPoolSize(10);  
//        config.addAddress("127.0.0.1:6379");  
//        Redisson redisson = Redisson.create(config);  
//        System.out.println("reids连接成功...");  
//  
//        // 2.测试concurrentMap,put方法的时候就会同步到redis中  
//        ConcurrentMap<String, Object> map = redisson.getMap("FirstMap");  
//        map.put("xx", "女");  
//        map.put("zhangsan", "男");  
//        map.put("lisi", "女");  
//  
//        ConcurrentMap<String, Object> resultMap = redisson.getMap("FirstMap");  
//        System.out.println("resultMap=" + resultMap.keySet());  
//        System.out.println("resultMap=" + resultMap.values());  
//  
//        // 2.测试Set集合  
//        Set<String> mySet = redisson.getSet("MySet");  
//        mySet.add("xx");  
//        mySet.add("lisi");  
//  
//        System.out.println("mySet.size=" + mySet.size());  
//  
//        //3.测试Queue队列  
//        Queue<String> myQueue = redisson.getQueue("FirstQueue");  
//        myQueue.add("xx");  
//        myQueue.add("lili");  
//        myQueue.add("zhangsan");  
//        myQueue.peek();  
//        myQueue.poll();  
//  
//        System.out.println("myQueue=" + myQueue);  
//  
//        // 关闭连接  
//        redisson.shutdown();  
//    }
//}
