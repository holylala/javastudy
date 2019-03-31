package com.threadesignbook.syncbasic2;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.threadesignbook
 * @Description:
 * @date 2019/3/21 23:11
 * @Company:
 */
public class ThreadInterruptTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {

            @Override
            public void run() {
                while(true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("CurrentThread Interrupted!");
                        break;
                    }
                    try {
                        Thread.sleep(2000);//sleep方法 中断会抛出异常 此时会清楚中断标记
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted When Sleep");
                        //再次设置中断标记
                        Thread.currentThread().interrupt();
                    }
                    Thread.yield();
                }
            }

        };
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();//通知目标线程中断 并设置中断标志位
    }

}
