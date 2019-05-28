package com.threadesignbook.jdkconcurrent3;

import java.util.concurrent.locks.LockSupport;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.threadesignbook.jdkconcurrent3
 * @Description: 线程阻塞工具类
 * @date 2019/5/4 9:50
 * @Company:
 */
public class LockSupportDemo2 {

    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread {

        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                LockSupport.park(this);//阻塞 可响应中断 直接返回
                if (Thread.interrupted()) {
                    System.out.println(getName() + " 被中断了...");
                }
            }
            System.out.println(getName() + "执行结束");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        t1.interrupt();
        LockSupport.unpark(t2);
    }

}
