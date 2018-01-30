package com.huang.hqjava.datastrut.concurrency.list;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhenqionghuang
 * @version V1.0
 * @Package com.huang.hqjava.datastrut.concurrency.list
 * @Description:
 * @date 2018/1/30 15:38
 * @Company:
 */
public class CounterPoolExecutor extends ThreadPoolExecutor {

	private AtomicInteger count = new AtomicInteger(0);
	public long startTime = 0;
	public String funcname = "";

	public CounterPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, LinkedBlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	protected void afterExecute(Runnable r, Throwable t) {
		int l = count.addAndGet(1); //每次执行完成一个任务就加1
		System.out.println("complete :>>>"+l);
		if (l == 300) {
			System.out.println(funcname + " spend time:>>" + (System.currentTimeMillis()-startTime) + ", l is "+l);
		}
	}

}
