/**
 * 
 */
package com.huang.work.desinmodel.zhuangshi;

/**   
 * @Title: PackDecorator.java 
 * @Package com.huang.work.desinmodel.zhuangshi 
 * @Description: TODO
 * @Copyright£º Copyright(c)2015
 * @Company£ºBjrun 
 * @author zhenqiong zhenqiong@run.com   
 * @date 2015-11-25 ÏÂÎç05:10:13 
 * @version V1.0   
 */
public abstract class PackDecorator implements IPackCreator {
	
	IPackCreator compent;
	
	public PackDecorator(IPackCreator c) {
		compent = c;
	}
	
	/*
	 * <p>Title: handelContent</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see com.huang.work.desinmodel.zhuangshi.IPackCreator#handelContent() 
	 */
	@Override
	public String handelContent() {
		return null;
	}

}
