package com.threadesignbook.jdkconcurrent3;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.threadesignbook.jdkconcurrent3
 * @Description:
 * @date 2019/4/24 22:49
 * @Company:
 */
public class ReadWriteLockDemo {

    private static Lock lock = new ReentrantLock();
    //读写锁
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    private int value;

    public Object handleRead(Lock lock) throws Exception {
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("read value:>>>" + value);
            return value;
        } finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock,int index) throws Exception {
        try {
            lock.lock(); //模拟写操作
            Thread.sleep(1000);
            value = index;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        final ReadWriteLockDemo demo = new ReadWriteLockDemo();

        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    demo.handleRead(readLock);//读不阻塞
                    //demo.handleRead(lock);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable writeRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    demo.handleWrite(writeLock,new Random().nextInt());
                    //demo.handleWrite(lock,new Random().nextInt());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 18; i++) {

            if(i==3 || i==7 || i==16) {
                new Thread(writeRunnable).start();
            } else {
                new Thread(readRunnable).start();
            }
        }

    }

}
