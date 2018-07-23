/**
 * 
 */
package com.huang.ioc;

/**   
 * @Title: SpElTest.java 
 * @Package com.huang.ioc 
 * @Description: TODO
 * @Copyright： Copyright(c)2015
 * @Company：Bjrun 
 * @author zhenqiong zhenqiong@
 * @date 2015-12-8 下午03:48:51 
 * @version V1.0   
 */
public class SpElTest {
	
	private String strvalue;
	private int intvalue;
	private double doublevalue;
	private boolean boolvalue;
	
	private Instrument instrument;
	
	public Instrument getInstrument() {
		return instrument;
	}
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	public String getStrvalue() {
		return strvalue;
	}
	public void setStrvalue(String strvalue) {
		this.strvalue = strvalue;
	}
	public int getIntvalue() {
		return intvalue;
	}
	public void setIntvalue(int intvalue) {
		this.intvalue = intvalue;
	}
	public double getDoublevalue() {
		return doublevalue;
	}
	public void setDoublevalue(double doublevalue) {
		this.doublevalue = doublevalue;
	}
	public boolean isBoolvalue() {
		return boolvalue;
	}
	public void setBoolvalue(boolean boolvalue) {
		this.boolvalue = boolvalue;
	}
	
	
}
