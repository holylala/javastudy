/**
 * 
 */
package com.huang.work.desinmodel.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**   
 * @Title: FutureTaskTest.java 
 * @Package com.huang.work.desinmodel.thread 
 * @Description: TODO
 * @Copyright�� Copyright(c)2015
 * @Company��Bjrun 
 * @author zhenqiong zhenqiong@run.com   
 * @date 2015-11-27 ����10:41:03 
 * @version V1.0   
 */
public class FutureTaskTest {

	/** 
	 * @Title: main 
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws 
	 */
	public static void main(String[] args) {
		FutureTask<String> future = new FutureTask<String>(new RealData("huang"));
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.submit(future);
		System.out.println("�������....");
		try {
			System.out.println("ִ����������.....");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("���󷵻ؽ��:"+future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		executor.shutdown();
	}

}
