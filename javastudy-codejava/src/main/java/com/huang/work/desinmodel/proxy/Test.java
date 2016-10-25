/**
 * 
 */
package com.huang.work.desinmodel.proxy;

/**   
 * @Title: Test.java 
 * @Package com.huang.work.desinmodel.proxy 
 * @Description: TODO
 * @Copyright£º Copyright(c)2015
 * @Company£ºBjrun 
 * @author zhenqiong zhenqiong@run.com   
 * @date 2015-11-25 ÏÂÎç03:16:29 
 * @version V1.0   
 */
public class Test {

	/** 
	 * @Title: main 
	 * @Description: 
	 * @param @param args
	 * @return void
	 * @throws 
	 */
	public static void main(String[] args) {
		
		IDBQuery dbquery = new DBQueryProxy();
		dbquery.request();
	}

}
