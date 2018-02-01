package com.huang.hqjava.datastrut.concurrency.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author zhenqionghuang
 * @version V1.0
 * @Package com.huang.hqjava.datastrut.concurrency.set
 * @Description:
 * @date 2018/2/1 13:39
 * @Company:
 */
public class RunMain {

	public static void main(String[] args) {
		//适用于读多写少的高并发场合
		CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
		//适用于读少写多的高并发场合
		Collections.synchronizedSet(new HashSet<String>());
	}

}
