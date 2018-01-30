package com.huang.hqjava.datastrut.concurrency.list;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zhenqionghuang
 * @version V1.0
 * @Package com.huang.hqjava.datastrut.concurrency.list
 * @Description:
 * @date 2018/1/30 15:45
 * @Company:
 */
public class RudMain {

	public static void main(String[] args) {

		CounterPoolExecutor executor = new CounterPoolExecutor(2000,2000,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());

		long starttime = System.currentTimeMillis();
		executor.startTime = starttime;
		executor.funcname = "testGetCopyOnWriteList";

		for (int i = 0; i < 4000 ; i++) {
			executor.submit(new AccessListThread()); // 访问List  4000个线程
		}

	}

}
