/**
 * 
 */
package com.huang.ioc;

/**   
 * @Title: Juggler.java 
 * @Package com.huang.ioc 
 * @Description: 杂技师
 * @Copyright： Copyright(c)2015
 * @Company：Bjrun 
 * @author zhenqiong zhenqiong@run.com   
 * @date 2015-12-4 下午03:29:43 
 * @version V1.0   
 */
public class Juggler implements Performer {

	private int beanBags = 3;
	
	public Juggler() {
		System.out.println("Juggler创建了");
	}
	
	public Juggler(int beanBags) {
		this.beanBags = beanBags;
	}
	
	/*
	 * <p>Title: performer</p> 
	 * <p>Description: </p>  
	 * @see com.huang.ioc.Performer#performer() 
	 */
	@Override
	public void performer() {
		System.out.println("杂技师:在抛 "+beanBags+" 个球........");
	}

}
