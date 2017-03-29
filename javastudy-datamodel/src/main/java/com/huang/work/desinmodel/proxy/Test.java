/**
 * 
 */
package com.huang.work.desinmodel.proxy;

import net.sf.cglib.proxy.Enhancer;

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

		//createJdkProxy();

		createCglibProxy();
	}

	public static void createJdkProxy() {
		IDBQuery jdkProxy = (IDBQuery) Proxy.newProxyInstance(
				ClassLoader.getSystemClassLoader(),
				new Class[] {IDBQuery.class},
				new JdkDbQueryHandler()
				);
		jdkProxy.request();
	}

	public static void createCglibProxy() {

		Enhancer enhancer = new Enhancer();
		//指定切入器 定义代理类逻辑
		enhancer.setCallback(new CglibDbQueryInterceptor());
		//指定实现的接口
		enhancer.setInterfaces(new Class[]{IDBQuery.class});
		//生成代理类的实例
		IDBQuery cglibProxy = (IDBQuery)enhancer.create();
		cglibProxy.request();

	}

	public static void sampleProxy() {
		IDBQuery dbquery = new DBQueryProxy();
		dbquery.request();
	}
}
