package com.threadesignbook.jdkconcurrent3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.threadesignbook.jdkconcurrent3
 * @Description:
 * @date 2019/4/3 23:24
 * @Company:
 */
public class FairLockDemo implements Runnable {

    public static ReentrantLock fairLock = new ReentrantLock(true);//公平锁 synchronize不是公平的锁


    @Override
    public void run() {
        while (true) {
            try {
                fairLock.lock();
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " 获得锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FairLockDemo fairLockDemo = new FairLockDemo();
        Thread t1 = new Thread(fairLockDemo,"ThreadOne");
        Thread t2 = new Thread(fairLockDemo,"ThreadTwo");
        t1.start();
        t2.start();
    }
}
