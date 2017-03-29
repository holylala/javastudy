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
		//ָ�������� ����������߼�
		enhancer.setCallback(new CglibDbQueryInterceptor());
		//ָ��ʵ�ֵĽӿ�
		enhancer.setInterfaces(new Class[]{IDBQuery.class});
		//���ɴ������ʵ��
		IDBQuery cglibProxy = (IDBQuery)enhancer.create();
		cglibProxy.request();

	}

	public static void sampleProxy() {
		IDBQuery dbquery = new DBQueryProxy();
		dbquery.request();
	}
}
