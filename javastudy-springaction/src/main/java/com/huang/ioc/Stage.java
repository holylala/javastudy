/**
 * 
 */
package com.huang.ioc;

/**   
 * @Title: Stage.java 
 * @Package com.huang.ioc 
 * @Description: TODO
 * @Copyright： Copyright(c)2015
 * @Company：Bjrun 
 * @author zhenqiong zhenqiong@run.com   
 * @date 2015-12-4 下午06:27:39 
 * @version V1.0   
 */
public class Stage {
	
	private Stage() {
		System.out.println("单例类创建了......");
	}
	
	private static class StageSingletonHolder {
		static Stage st = new Stage();
	}
	
	public static Stage getInstance() {
		return StageSingletonHolder.st;
	}
}
