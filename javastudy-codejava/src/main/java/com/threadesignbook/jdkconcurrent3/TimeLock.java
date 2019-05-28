package com.threadesignbook.jdkconcurrent3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.threadesignbook.jdkconcurrent3
 * @Description:
 * @date 2019/4/2 22:55
 * @Company:
 */
public class TimeLock implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {// 请求锁 设置5秒超时 如果超时还获取不到锁则返回false
                System.out.println(Thread.currentThread().getName() + " get lock successed.");
                Thread.sleep(6000);
            } else {
                System.out.println(Thread.currentThread().getName() + " get lock failed.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TimeLock timeLock = new TimeLock();
        Thread t1 = new Thread(timeLock);
        Thread t2 = new Thread(timeLock);
        t1.start();
        t2.start();
    }
}
