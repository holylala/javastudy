/**
 * 
 */
package com.huang.ioc;

/**   
 * @Title: Auditorium.java 
 * @Package com.huang.ioc 
 * @Description: TODO
 * @Copyright： Copyright(c)2015
 * @Company：Bjrun 
 * @author zhenqiong zhenqiong@
 * @date 2015-12-5 上午10:35:33 
 * @version V1.0   
 */
public class Auditorium {
	
	
	public void init() {
		System.out.println("init.......");
	}
	
	public Auditorium() {
		System.out.println("创建 Auditorium......");
	}
	
	public void turnOnLights() {
		System.out.println("开灯.......");
	}
	
	public void turnOffLights() {
		System.out.println("关灯.......");
	}
	
	public void destroy() {
		System.out.println("destroy.......");
	}
}
