/**
 * 
 */
package com.huang.work.desinmodel.proxy;

/**   
 * @Title: DBQueryProxy.java 
 * @Package com.huang.work.desinmodel.proxy 
 * @Description: TODO
 * @Copyright£º Copyright(c)2015
 * @Company£ºBjrun 
 * @author zhenqiong zhenqiong@run.com   
 * @date 2015-11-25 ÏÂÎç03:14:07 
 * @version V1.0   
 */
public class DBQueryProxy implements IDBQuery {

	private DBQuery real;
	/*
	 * <p>Title: request</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see com.huang.work.desinmodel.proxy.IDBQuery#request() 
	 */
	@Override
	public String request() {
		if (real == null) {
			real = new DBQuery();
		}
		return real.request();
	}

}
