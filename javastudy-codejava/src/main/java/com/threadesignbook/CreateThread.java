package com.threadesignbook;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.threadesignbook
 * @Description:
 * @date 2019/3/14 23:17
 * @Company:
 */
public class CreateThread implements Runnable {

    public static void main(String[] args)  throws  Exception {
        Thread t1 = new Thread(new CreateThread());
        //t1.start();

        Thread t2 = new Thread(new CreateThread2());
        //t1.join();
        //t2.start();

        Thread t3 = new Thread() {
            @Override
            public void run() {
                System.out.println("inner thread running...");
            }
        };
        //t2.join();


        t3.start();
        t3.join();
        t2.start();
        t2.join();
        t1.start();
    }

    @Override
    public void run() {
        System.out.println("Runnable.");
    }
}
