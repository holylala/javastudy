/**
 * 
 */
package com.huang.work.desinmodel.zhuangshi;

/**   
 * @Title: PackHtmlCreator.java 
 * @Package com.huang.work.desinmodel.zhuangshi 
 * @Description: TODO
 * @Copyright�� Copyright(c)2015
 * @Company��Bjrun 
 * @author zhenqiong zhenqiong@run.com   
 * @date 2015-11-25 ����05:26:41 
 * @version V1.0   
 */
public class PackHtmlCreator extends PackDecorator {

	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @param c 
	*/
	public PackHtmlCreator(IPackCreator c) {
		super(c);
	}
	
	@Override
	public String handelContent() {
		StringBuffer sb = new StringBuffer();
		sb.append("<HTML>");
		sb.append("<Body>");
		sb.append(compent.handelContent());
		sb.append("</Body>");
		sb.append("</HTML>");
		return sb.toString();
	}

}
