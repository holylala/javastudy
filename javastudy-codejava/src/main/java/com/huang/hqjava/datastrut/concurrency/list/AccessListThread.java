package com.huang.hqjava.datastrut.concurrency.list;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author zhenqionghuang
 * @version V1.0
 * @Package com.huang.hqjava.datastrut.concurrency.list
 * @Description:
 * @date 2018/1/30 15:06
 * @Company:
 */
public class AccessListThread implements Runnable {

	protected  String name;
	Random rand = new Random();
	CopyOnWriteArrayList list = null;

	public AccessListThread() {
		list = new CopyOnWriteArrayList(new ArrayList<String>(1000));
		for (int i = 0; i < 500; i++) {
			list.add(i+"");
		}
	}

	public AccessListThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 500; i++) {
				getList(rand.nextInt(100));
			}
			Thread.sleep(rand.nextInt(100));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Object getList(int i) {
		return list.get(i);
	}

}
