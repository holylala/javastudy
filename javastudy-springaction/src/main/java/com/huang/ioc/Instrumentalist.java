/**
 * 
 */
package com.huang.ioc;

/**   
 * @Title: Instrumentalist.java 
 * @Package com.huang.ioc 
 * @Description: TODO
 * @Copyright： Copyright(c)2015
 * @Company：Bjrun 
 * @author zhenqiong zhenqiong@
 * @date 2015-12-5 上午11:16:32 
 * @version V1.0   
 */
public class Instrumentalist implements Performer {

	
	public Instrumentalist() {
		
	}
	
	private String song;
	
	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	private Instrument instrument;
	
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	/*
	 * <p>Title: performer</p> 
	 * <p>Description: </p>  
	 * @see com.huang.ioc.Performer#performer() 
	 */
	@Override
	public void performer() {
		System.out.println("sing ：>>>"+getSong()+",使用：>>>");
		instrument.paly();
	}

}
