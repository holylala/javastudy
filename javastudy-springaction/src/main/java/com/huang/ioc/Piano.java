/**
 * 
 */
package com.huang.ioc;

/**   
 * @Title: Jita.java 
 * @Package com.huang.ioc 
 * @Description: TODO
 * @Copyright： Copyright(c)2015
 * @Company：Bjrun 
 * @author zhenqiong zhenqiong@
 * @date 2015-12-5 下午01:56:59 
 * @version V1.0   
 */
public class Piano implements Instrument {

	/*
	 * <p>Title: paly</p> 
	 * <p>Description: </p>  
	 * @see com.huang.ioc.Instrument#paly() 
	 */
	@Override
	public void paly() {
		System.out.println("钢琴弹奏......");
	}

}
