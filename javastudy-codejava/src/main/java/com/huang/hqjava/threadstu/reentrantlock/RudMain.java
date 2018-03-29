package com.huang.hqjava.threadstu.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhenqionghuang
 * @version V1.0
 * @Package com.huang.hqjava.threadstu.reentrantlock
 * @Description:
 * @date 2018/2/7 16:07
 * @Company:
 */
public class RudMain {

	private static Runnable createTask() {
		final ReentrantLock lock = new ReentrantLock();
		return new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						if (lock.tryLock(500, TimeUnit.MILLISECONDS)) {
							try {
								System.out.println("locked 获得锁" + Thread.currentThread().getName());
								Thread.sleep(1000);
							} finally {
								lock.unlock();
								System.out.println("Unlocked 释放锁" + Thread.currentThread().getName());
							}
							break;
						} else {
							System.out.println("获取不到锁 " + Thread.currentThread().getName());
						}
					} catch (InterruptedException e) {
						System.out.println(Thread.currentThread().getName() + " 被中断....");
					}
				}
			}
		};
	}


	public static void main(String[] args) throws InterruptedException {

		Thread first = new Thread(RudMain.createTask(),"FirestThread");
		Thread second = new Thread(RudMain.createTask(),"SecondThread");
		first.start();
		second.start();
		Thread.sleep(600);
		second.interrupt();
	}

}
