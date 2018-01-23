/**
 * 
 */
package com.huang.optimize.concurrency.productandcus;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**   
 * @Title: Produtor.java 
 * @Package com.huang.work.desinmodel.thread 
 * @Description:
 * @Copyright： Copyright(c)2015
 * @Company：Bjrun 
 * @author zhenqiong zhenqiong@run.com   
 * @date 2015-11-27 上午11:32:28 
 * @version V1.0   
 */
public class Produtor implements Runnable {

	private volatile boolean isRunning = true;
	private BlockingQueue<PCData> queue;
	private static AtomicInteger count = new AtomicInteger();//总数 原子操作
	private static final int SLEEPTIME = 1000;
	
	public Produtor(BlockingQueue<PCData> queue) {
		this.queue = queue;
	}
	
	/*
	 * <p>Title: run</p> 
	 * <p>Description: </p>  
	 * @see java.lang.Runnable#run() 
	 */
	@Override
	public void run() {
		
		PCData data = null;
		Random r = new Random();
		System.out.println("Start productor id:>>>" + Thread.currentThread().getId());
		
		try {
			while(isRunning) {
				Thread.sleep(r.nextInt(SLEEPTIME));
				data = new PCData(count.incrementAndGet());
				System.out.println("Produtor:>>" + data + " is put into queue...");
				if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
					System.err.println("Fail to put data into queue...");
				}
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	}
	
	public void stop() {
		isRunning = false;
	}

}
