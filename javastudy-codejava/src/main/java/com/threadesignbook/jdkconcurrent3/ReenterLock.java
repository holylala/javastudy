package com.threadesignbook.jdkconcurrent3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.threadesignbook.jdkconcurrent3
 * @Description:
 * @date 2019/4/2 22:47
 * @Company:
 */
public class ReenterLock implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {

            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock reenterLock = new ReenterLock();
        Thread t1 = new Thread(reenterLock);
        Thread t2 = new Thread(reenterLock);
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println("i value is :" + i);
    }

}
