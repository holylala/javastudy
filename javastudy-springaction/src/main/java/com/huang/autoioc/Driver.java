/**
 * 
 */
package com.huang.autoioc;

import org.springframework.stereotype.Component;

/**   
 * @Title: Driver.java 
 * @Package com.huang.autoioc 
 * @Description: TODO
 * @Copyright： Copyright(c)2015
 * @Company：Bjrun 
 * @author zhenqiong zhenqiong@run.com   
 * @date 2015-12-9 上午11:27:37 
 * @version V1.0   
 */
//如果不知道bean id为driver1 默认就是类的无限定名称driver
@Component("driver1")
public class Driver implements Person {

	/*
	 * <p>Title: speak</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see com.huang.autoioc.Person#speak() 
	 */
	@Override
	public String speak() {
		return "我是位司机....";
	}

}
