package com.huang.hqjava.executorpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhenqionghuang
 * @version V1.0
 * @Package com.huang.hqjava.executorpool
 * @Description:
 * @date 2018/1/26 16:17
 * @Company:
 */
public class RunMain {

	public static void main(String[] args) {
		ExecutorService exe = new ThreadPoolExecutor(100,200,0L, TimeUnit.SECONDS,new PriorityBlockingQueue<Runnable>());
		for (int i = 0; i < 1000 ; i++) {
			exe.execute(new MyThread("Work Thread Name_"+Integer.toString(999-i)));
		}
	}

}
