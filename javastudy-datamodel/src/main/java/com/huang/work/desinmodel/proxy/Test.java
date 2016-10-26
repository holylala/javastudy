/**
 * 
 */
package com.huang.work.desinmodel.proxy;

import java.lang.reflect.Proxy;


public class Test {

	/** 
	 * @Title: main 
	 * @Description: 
	 * @param @param args
	 * @return void
	 * @throws 
	 */
	public static void main(String[] args) {

		createJdkProxy();
	}

	public static void createJdkProxy() {
		IDBQuery jdkProxy = (IDBQuery) Proxy.newProxyInstance(
				ClassLoader.getSystemClassLoader(),
				new Class[] {IDBQuery.class},
				new JdkDbQueryHandler()
				);
		jdkProxy.request();
	}

	public static void sampleProxy() {
		IDBQuery dbquery = new DBQueryProxy();
		dbquery.request();
	}
}
