package com.threadesignbook.jdkconcurrent3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.threadesignbook.jdkconcurrent3
 * @Description:
 * @date 2019/4/23 22:37
 * @Company:
 */
public class SemapDemo implements Runnable {

    final Semaphore semp = new Semaphore(5);//可以指定多个线程同时访问某一个资源

    @Override
    public void run() {
        try {
            semp.acquire();
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getId() + ": done!");
            semp.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        final SemapDemo demo = new SemapDemo();
        for (int i = 0; i < 20; i++) {
            exec.submit(demo);
        }
        exec.shutdown();
    }
}
