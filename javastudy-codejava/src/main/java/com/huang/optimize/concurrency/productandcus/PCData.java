/**
 * 
 */
package com.huang.optimize.concurrency.productandcus;


public final class PCData {
	
	private final int intData;
	
	public PCData(int d) {
		intData = d;
	}
	
	public PCData(String d) {
		intData = Integer.parseInt(d);
	}

	public int getIntData() {
		return intData;
	}
	
	public String toString() {
		return ""+intData;
	}
}
