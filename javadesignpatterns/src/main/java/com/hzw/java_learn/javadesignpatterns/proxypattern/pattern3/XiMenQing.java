package com.hzw.java_learn.javadesignpatterns.proxypattern.pattern3;

import com.hzw.java_learn.javadesignpatterns.proxypattern.JiaShi;
import com.hzw.java_learn.javadesignpatterns.proxypattern.PanJinLian;

/**
 * @author houzw
 *
 */
public class XiMenQing {
	public static void main(String[] args) {
		
		PanJinLian panJinLian = (PanJinLian) new WangPo(new PanJinLian()).getProxyInstance();
		// 获取代理对象的目标可以只是一个单独的对象
		
		panJinLian.makeEyesWithMan();
		panJinLian.happyWithMan();
		
		
		JiaShi jiaShi = new WangPo().getProcxyInstance(JiaShi.class);
		// 获取代理对象的目标可以只是一个单独的对象
		
		jiaShi.makeEyesWithMan();
		jiaShi.happyWithMan();
		
		
	}
}
