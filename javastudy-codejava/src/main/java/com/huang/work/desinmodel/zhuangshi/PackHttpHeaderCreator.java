/**
 * 
 */
package com.huang.work.desinmodel.zhuangshi;

/**   
 * @Title: PackHttpHeaderCreator.java 
 * @Package com.huang.work.desinmodel.zhuangshi 
 * @Description: TODO
 * @Copyright£º Copyright(c)2015
 * @Company£ºBjrun 
 * @author zhenqiong zhenqiong@run.com   
 * @date 2015-11-25 ÏÂÎç05:38:54 
 * @version V1.0   
 */
public class PackHttpHeaderCreator extends PackDecorator {

	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @param c 
	*/
	public PackHttpHeaderCreator(IPackCreator c) {
		super(c);
	}
	
	@Override
	public String handelContent() {
		StringBuffer sb = new StringBuffer();
		sb.append("header1:xxxxx-xxxx");
		sb.append("header2:xxxxx-xxxx");
		sb.append(compent.handelContent());
		return sb.toString();
	}

}
