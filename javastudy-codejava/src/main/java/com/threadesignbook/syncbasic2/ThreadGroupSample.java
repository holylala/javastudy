package com.threadesignbook.syncbasic2;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.threadesignbook
 * @Description:
 * @date 2019/3/28 0:02
 * @Company:
 */
public class ThreadGroupSample implements Runnable {

    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("PrintGroup");
        Thread t1 = new Thread(tg,new ThreadGroupSample(),"T1");
        Thread t2 = new Thread(tg,new ThreadGroupSample(),"T2");
        t1.start();
        t2.start();
        System.out.println(tg.activeCount());
        tg.list();
    }

    @Override
    public void run() {
        String goupNameAndThreadName = Thread.currentThread().getThreadGroup().getName() + "-" +
                Thread.currentThread().getName();
        while (true) {
            System.out.println("I am " + goupNameAndThreadName);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
