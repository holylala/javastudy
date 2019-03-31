package com.threadesignbook.syncbasic2;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.threadesignbook
 * @Description:
 * @date 2019/3/31 18:26
 * @Company:
 */
public class SynchronyDemo2 implements Runnable {

    static SynchronyDemo2 instance = new SynchronyDemo2();
    static int i = 0;
    public static synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new SynchronyDemo2()); //不是一个instance对象 synchronized void increase()
        // 实例方法不能保证线程安全, 改成 static synchronized void increase() 类的方法 就可以 因为是同一个类
        Thread t2 = new Thread(new SynchronyDemo2());
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println("i value:" + i);
    }
}
