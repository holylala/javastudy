/**
 * 
 */
package com.huang.aop;

/**   
 * @Title: Girl.java 
 * @Package com.huang.aop 
 * @Description: TODO
 * @Copyright： Copyright(c)2015
 * @Company：Bjrun 
 * @author zhenqiong zhenqiong@run.com   
 * @date 2015-12-23 下午05:29:10 
 * @version V1.0   
 */
public class Girl implements Thinker {
	
	private String mindinfos;
	
	/*
	 * <p>Title: thinkSometing</p> 
	 * <p>Description: </p> 
	 * @param mindinfos 
	 * @see com.huang.aop.Thinker#thinkSometing(java.lang.String) 
	 */
	@Override
	public void thinkSometing(String mindinfos) {
		this.mindinfos = mindinfos;
	}
	
	public String getMindInfos() {
		return mindinfos;
	}
	
}
