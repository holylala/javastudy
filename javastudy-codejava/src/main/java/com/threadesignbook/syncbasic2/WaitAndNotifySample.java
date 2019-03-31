package com.threadesignbook.syncbasic2;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.threadesignbook
 * @Description:
 * @date 2019/3/23 23:18
 * @Company:
 */
public class WaitAndNotifySample {

    final static Object obj = new Object();

    public static class T1 extends Thread {
        public void run() {
            synchronized (obj) {
                System.out.println(System.currentTimeMillis() + ": T1 start!");
                try {
                    System.out.println(System.currentTimeMillis() + ": T1 wait for object ");
                    obj.wait();//wait() 必须包含在对应的synchronized同步语句中,执行前需要获得目标对象的一个监听器
                    //执行后进入Object对象的等待队列中
                    //并释放obj对象的锁
                    //T1 在得到notify()通知后,还是会先尝试重新获取obj对象的锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ": T1 end!");
            }
        }
    }

    public static class T2 extends Thread {

        public void run() {
            synchronized (obj) {
                System.out.println(System.currentTimeMillis() + ": T2 start! notify one Thread");
                obj.notify();//notify()必须包含在对应的synchronized同步语句中,执行前需要获得目标对象的一个监听器
                //唤醒进入Object对象的等待队列中的一个线程
                System.out.println(System.currentTimeMillis() + ": T2 end!");
                try {
                    Thread.sleep(2000);//sleep方法不会释放任何资源
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }
}
