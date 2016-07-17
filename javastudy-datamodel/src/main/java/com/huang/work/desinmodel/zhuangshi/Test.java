/**
 * 
 */
package com.huang.work.desinmodel.zhuangshi;

/**   
 * @Title: Test.java 
 * @Package com.huang.work.desinmodel.zhuangshi 
 * @Description: TODO
 * @Copyright£º Copyright(c)2015
 * @Company£ºBjrun 
 * @author zhenqiong zhenqiong@run.com   
 * @date 2015-11-25 ÏÂÎç05:41:47 
 * @version V1.0   
 */
public class Test {

	/** 
	 * @Title: main 
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws 
	 */
	public static void main(String[] args) {
		IPackCreator pc = new PackHttpHeaderCreator(new PackHtmlCreator(new PackBodyCreator()));
		String outstr = pc.handelContent();
		System.out.println(outstr);
	}

}
