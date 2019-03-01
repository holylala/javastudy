/**
 * 
 */
package com.huang.ioc;

/**   
 * @Title: Stage.java 
 * @Package com.huang.ioc 
 * @Description:
 * @Copyright： Copyright(c)2015
 * @Company：Bjrun 
 * @author zhenqiong zhenqiong@
 * @date 2015-12-4 下午06:27:39 
 * @version V1.0   
 */
public class Stage {
	
	private Stage() {
		System.out.println("单例类创建了......");
	}
	
	private static class StageSingletonHolder { //延迟加载实例
		static Stage st = new Stage();
	}
	
	public static Stage getInstance() { //返回实例
		return StageSingletonHolder.st;
	}
}
