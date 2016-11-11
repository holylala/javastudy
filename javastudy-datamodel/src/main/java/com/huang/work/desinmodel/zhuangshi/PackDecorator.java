/**
 * 
 */
package com.huang.work.desinmodel.zhuangshi;

/**   
 * @Title: PackDecorator.java 
 * @Package com.huang.work.desinmodel.zhuangshi 
 * @Description: 全权委托 compent 对象
 * @Copyright： Copyright(c)2015
 * @Company：Bjrun 
 * @author zhenqiong zhenqiong@run.com   
 * @date 2015-11-25 下午05:10:13 
 * @version V1.0   
 */
//有抽象方法的类一定是抽象类。但是抽象类中不一定都是抽象方法，也可以全是具体方法。
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
