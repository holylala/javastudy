package com.huang.iodemo;

import java.util.concurrent.CountDownLatch;

public class ThreadMMODemo {

    public static void main(String[] args) {

        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {
            Thread.sleep(20000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 5000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();//每个线程都被阻塞
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            System.out.println("i= " + i);
        }

    }

}
