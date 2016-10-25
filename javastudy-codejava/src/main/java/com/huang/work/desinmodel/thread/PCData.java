/**
 * 
 */
package com.huang.work.desinmodel.thread;

/**   
 * @Title: PCData.java 
 * @Package com.huang.work.desinmodel.thread 
 * @Description: TODO
 * @Copyright£º Copyright(c)2015
 * @Company£ºBjrun 
 * @author zhenqiong zhenqiong@run.com   
 * @date 2015-11-27 ÉÏÎç11:25:26 
 * @version V1.0   
 */
public final class PCData {
	
	private final int intData;
	
	public PCData(int d) {
		intData = d;
	}
	
	public PCData(String d) {
		intData = Integer.parseInt(d);
	}

	public int getIntData() {
		return intData;
	}
	
	public String toString() {
		return ""+intData;
	}
}
