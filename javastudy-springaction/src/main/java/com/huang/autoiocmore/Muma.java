/**
 * 
 */
package com.huang.autoiocmore;

import org.springframework.stereotype.Component;

/**   
 * @Title: Muma.java 
 * @Package com.huang.autoiocmore 
 * @Description: TODO
 * @Copyright： Copyright(c)2015
 * @Company：Bjrun 
 * @author zhenqiong zhenqiong@
 * @date 2015-12-16 上午10:57:52 
 * @version V1.0   
 */
@Component("muma")
public class Muma implements Toy {

	/*
	 * <p>Title: play</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see com.huang.autoiocmore.Toy#play() 
	 */
	@Override
	public String play() {
		return "旋转的木马 没有悲伤....";
	}

}
