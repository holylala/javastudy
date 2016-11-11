/**
 * 
 */
package com.huang.work.desinmodel.zhuangshi;

/**   
 * @Title: PackBodyCreator.java 
 * @Package com.huang.work.desinmodel.zhuangshi 
 * @Description: 构造核心数据,但是不包括格式
 * @Copyright： Copyright(c)2015
 * @Company：Bjrun 
 * @author zhenqiong zhenqiong@run.com   
 * @date 2015-11-25 下午05:04:52 
 * @version V1.0   
 */
public class PackBodyCreator implements IPackCreator {

	/*
	 * <p>Title: handelContent</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see com.huang.work.desinmodel.zhuangshi.IPackCreator#handelContent() 
	 */
	@Override
	public String handelContent() {
		return "Content of body";
	}

}
