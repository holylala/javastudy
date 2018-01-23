/**
 * 
 */
package com.huang.optimize.concurrency.productandcus;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**   
 * @Title: Consumer.java 
 * @Package com.huang.work.desinmodel.thread 
 * @Description: 
 * @Copyright£º Copyright(c)2015
 * @Company£ºBjrun 
 * @author zhenqiong zhenqiong@run.com   
 * @date 2015-11-27 ÏÂÎç01:46:11 
 * @version V1.0   
 */
public class Consumer implements Runnable {
	
	private BlockingQueue<PCData> queue;
	private static final int SLEEPTIME = 1000;
	
	public Consumer(BlockingQueue<PCData> queue) {
		this.queue = queue;
	}
	/*
	 * <p>Title: run</p> 
	 * <p>Description: </p>  
	 * @see java.lang.Runnable#run() 
	 */
	@Override
	public void run() {
		Random r = new Random();
		System.out.println("Start consumer id:>>>" + Thread.currentThread().getId());
		
		try {
			while(true) {
				
				PCData data = queue.take();
				if (data != null) {
					System.out.println("Consumer:>>" + data + " is get out of queue...");
					int re = data.getIntData() * data.getIntData();
					System.out.println(MessageFormat.format("{0}*{1}={2}", data.getIntData(),data.getIntData(),re));
					Thread.sleep(r.nextInt(SLEEPTIME));
				}
			
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	
	}

}
