/**
 * 
 */
package com.huang.autoiocmore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**   
 * @Title: Child.java 
 * @Package com.huang.autoiocmore 
 * @Description: TODO
 * @Copyright： Copyright(c)2015
 * @Company：Bjrun 
 * @author zhenqiong zhenqiong@run.com   
 * @date 2015-12-16 上午11:06:15 
 * @version V1.0   
 */
@Component("child")
public class Child {
	
	@Autowired(required = false)
	@Qualifier("muma")
	private Toy toy;

	public Toy getToy() {
		return toy;
	}

	public void setToy(Toy toy) {
		this.toy = toy;
	}
	
	public String play() {
		return toy.play();
	}
	
}
