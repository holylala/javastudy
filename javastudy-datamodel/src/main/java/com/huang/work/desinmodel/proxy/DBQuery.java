/**
 * 
 */
package com.huang.work.desinmodel.proxy;

/**   
 * @Title: DBQuery.java 
 * @Package com.huang.work.desinmodel.proxy 
 * @Description: TODO
 * @Copyright： Copyright(c)2015
 * @Company：Bjrun 
 * @author zhenqiong zhenqiong@run.com   
 * @date 2015-11-25 下午03:11:13 
 * @version V1.0   
 */
public class DBQuery implements IDBQuery {
	
	public DBQuery() { //比较耗时的操作
		System.out.println("比较耗时的操作.....");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	/*
	 * <p>Title: request</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see com.huang.work.desinmodel.proxy.IDBQuery#request() 
	 */
	@Override
	public String request() {
		System.out.println("DBQuery 重量级对象 真正的主题.....");
		return "DBQuery 重量级对象 真正的主题.....";
	}

}
