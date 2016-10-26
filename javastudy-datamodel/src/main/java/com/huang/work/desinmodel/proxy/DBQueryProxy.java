/**
 * 
 */
package com.huang.work.desinmodel.proxy;

/**
 * 代理类
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
