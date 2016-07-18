/**
 * 
 */
package com.huang.work.desinmodel.thread;

import java.util.concurrent.Callable;

/**   
 * @Title: RealData.java 
 * @Package com.huang.work.desinmodel.thread 
 * @Description: 
 * @Copyright： Copyright(c)2015
 * @Company：Bjrun 
 * @author zhenqiong zhenqiong@run.com   
 * @date 2015-11-27 上午10:35:09 
 * @version V1.0   
 */
public class RealData implements Callable<String> {

	private String para;
	
	public RealData(String para) {
		this.para = para;
	}
	
	/*
	* <p>Title: call</p> 
	* <p>Description: </p> 
	* @return
	* @throws Exception 
	* @see java.util.concurrent.Callable#call() 
	*/
	@Override
	public String call() throws Exception {
		StringBuffer sb = new StringBuffer();
		System.out.println("执行请求的操作.......");
		for (int i = 0; i < 10; i++) {
			sb.append(para);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

}
