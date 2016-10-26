/**
 * 
 */
package com.huang.work.desinmodel.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * jdk自带的动态代理 功能相对弱
 */
public class JdkDbQueryHandler implements InvocationHandler {
	
	IDBQuery real; //主题接口
	/*
	 * <p>Title: invoke</p> 
	 * <p>Description: </p> 
	 * @param proxy
	 * @param method
	 * @param args
	 * @return
	 * @throws Throwable 
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]) 
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		if (real == null) {
			real = new DBQuery(); 
		}
		
		return real.request();
	}

}
