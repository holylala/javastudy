/**
 * 
 */
package com.huang.work.desinmodel.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**   
 * @Title: JdkDbQueryHandler.java 
 * @Package com.huang.work.desinmodel.proxy 
 * @Description: JDK�Դ��Ķ�̬����
 * @Copyright�� Copyright(c)2015
 * @Company��Bjrun 
 * @author zhenqiong zhenqiong@run.com   
 * @date 2015-11-25 ����03:41:34 
 * @version V1.0   
 */
public class JdkDbQueryHandler implements InvocationHandler {
	
	IDBQuery real; //����ӿ�
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
