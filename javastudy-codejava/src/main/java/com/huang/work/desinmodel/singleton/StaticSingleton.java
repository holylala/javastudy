/**
 * 
 */
package com.huang.work.desinmodel.singleton;

/**
 * @Title: StaticSingleton.java
 * @Package com.huang.work.desinmodel
 * @Description: 单例模式
 * @Copyright�� Copyright(c)2015
 * @Company��Bjrun
 * @author zhenqiong zhenqiong@run.com
 * @date 2015-11-25 ����10:50:49
 * @version V1.0
 */
public class StaticSingleton {  
	
	private StaticSingleton() {
		System.out.println("创建  StaticSingleton 类");
	}
	
	private static class StaticInnerClass {  
	   private static StaticSingleton instance = new StaticSingleton();
    }
	
	public static StaticSingleton getInstance() {
		return StaticInnerClass.instance;
	}
	
	
}  
	
