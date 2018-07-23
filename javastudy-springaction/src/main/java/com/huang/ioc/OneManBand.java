/**
 * 
 */
package com.huang.ioc;

import java.util.Collection;
import java.util.Map;

/**   
 * @Title: OneManBand.java 
 * @Package com.huang.ioc 
 * @Description: 集合属性的设值
 * @Copyright： Copyright(c)2015
 * @Company：Bjrun 
 * @author zhenqiong zhenqiong@
 * @date 2015-12-5 下午02:51:46 
 * @version V1.0   
 */
public class OneManBand implements Performer {

	//乐器列表
	private Collection<Instrument> instruments;
	
	private Map<String,Instrument> instrumentsmap;
	
	public OneManBand() {
		
	}
	
	public void setInstruments(Collection<Instrument> instruments) {
		this.instruments = instruments;
	}
		
	public void setInstrumentsmap(Map<String, Instrument> instrumentsmap) {
		this.instrumentsmap = instrumentsmap;
	}

	/*
	 * <p>Title: performer</p> 
	 * <p>Description: </p>  
	 * @see com.huang.ioc.Performer#performer() 
	 */
	@Override
	public void performer() {
		System.out.println("一个人的乐队......");
		for(Instrument instrument :instruments) {
			instrument.paly();
		}
		for(String key : instrumentsmap.keySet()) {
			System.out.println("乐器名称:>>>"+key);
			Instrument instrument = instrumentsmap.get(key);
			instrument.paly();
		}
	}

}
