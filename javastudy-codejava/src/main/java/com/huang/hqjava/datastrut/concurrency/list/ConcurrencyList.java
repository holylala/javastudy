package com.huang.hqjava.datastrut.concurrency.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author zhenqionghuang
 * @version V1.0
 * @Package com.huang.hqjava.datastrut.concurrency
 * @Description:
 * @date 2018/1/30 14:02
 * @Company:
 */
public class ConcurrencyList {

	public static void main(String[] args) {
		//几种并发List
		//适合写多读少的场合
		Vector vector = new Vector<String>();
		//适合读多写少的场合
		CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList<String>(new ArrayList<String>());
		Collections.synchronizedList(new ArrayList<Object>());
	}

}
