/**
 * 
 */
package com.huang.ioc;

/**   
 * @Title: PeticJuggler.java 
 * @Package com.huang.ioc 
 * @Description: 会诗歌的杂技师
 * @Copyright： Copyright(c)2015
 * @Company：Bjrun 
 * @author zhenqiong zhenqiong@run.com   
 * @date 2015-12-4 下午04:30:49 
 * @version V1.0   
 */
public class PeticJuggler extends Juggler {
	
	private Poem poem;
	
	public PeticJuggler(Poem poem) {
		super();
		this.poem = poem;
	}
	
	public PeticJuggler(int beanBags, Poem poem) {
		super(beanBags);
		this.poem = poem;
	}

	public void performer() {
		super.performer();
		System.out.println("同时进行.....");
		poem.recite();
	}
}
