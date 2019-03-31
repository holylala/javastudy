package com.threadesignbook.syncbasic2;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.threadesignbook
 * @Description:
 * @date 2019/3/31 18:26
 * @Company:
 */
public class SynchronyDemo implements Runnable {

    static SynchronyDemo instance = new SynchronyDemo();
    static int i = 0;
    public synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance); //都是一个instance对象 所以能保证线程安全
        Thread t2 = new Thread(instance);
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println("i value:" + i);
    }
}
