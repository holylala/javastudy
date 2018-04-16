/**
 * 
 */
package com.huang.optimize.concurrency.productandcus;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;


public class ProConTest {

	/**
	 * @throws InterruptedException  
	 * @Title: main 
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws 
	 */
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<PCData> queue = new LinkedBlockingQueue<PCData>(10);
		
		Produtor p1 = new Produtor(queue);
		Produtor p2 = new Produtor(queue);
		Produtor p3 = new Produtor(queue);
		
		Consumer c1 = new Consumer(queue);
		Consumer c2 = new Consumer(queue);
		Consumer c3 = new Consumer(queue);
		
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(p1);
		service.execute(p2);
		service.execute(p3);
		service.execute(c1);
		service.execute(c2);
		service.execute(c3);
		
		Thread.sleep(1000);
		p1.stop();
		p2.stop();
		p3.stop();
		
		Thread.sleep(3000);
		
		service.shutdown();

		System.out.println("shutdown");
	}

}
