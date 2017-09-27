package com.hzw.java_learn.javadesignpatterns.proxypattern.pattern2;

import com.hzw.java_learn.javadesignpatterns.proxypattern.JiaShi;
import com.hzw.java_learn.javadesignpatterns.proxypattern.KindWomen;
import com.hzw.java_learn.javadesignpatterns.proxypattern.PanJinLian;

public class XiMenQing {
	public static void main(String[] args) {
		
		WangPo wangPo = new WangPo();
		
		KindWomen women = (KindWomen) wangPo.bind(new PanJinLian());
		
		women.makeEyesWithMan();
		women.happyWithMan();
		
		women = (KindWomen) wangPo.bind(new JiaShi());
		women.makeEyesWithMan();
		women.happyWithMan();
		
		
		
	}
}
