/**
 * 
 */
package com.huang.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**   
 * @Title: GetMinder.java 
 * @Package com.huang.aop 
 * @Description: 
 * @Copyright： Copyright(c)2015
 * @Company：Bjrun 
 * @author zhenqiong zhenqiong@run.com   
 * @date 2015-12-23 下午05:23:04 
 * @version V1.0   
 */
@Aspect
public class GetMinder implements MindReader {

	private String mindinfos;
	
	//这里要指定是Girl类 写Thinker接口类会报错
	@Pointcut("execution(* com.huang.aop.Girl.thinkSometing(String)) && args(mindinfos)")
	public void thinkinga(String mindinfos) {
		
	}
	
	/*
	 * <p>Title: getOnesMind</p> 
	 * <p>Description: </p> 
	 * @param mindinfo 
	 * @see com.huang.aop.MindReader#getOnesMind(java.lang.String) 
	 */
	@Before("thinkinga(mindinfos)")
	public void getOnesMind(String mindinfos) {
		System.out.println("注解 GetMinder :获知某个人在想什么.......");
		this.mindinfos = mindinfos;
	}

	/*
	 * <p>Title: getMindInfo</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see com.huang.aop.MindReader#getMindInfo() 
	 */
	@Override
	public String getMindInfos() {
		return mindinfos;
	}

}
