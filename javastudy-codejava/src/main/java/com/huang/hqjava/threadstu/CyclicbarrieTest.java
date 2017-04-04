package com.huang.hqjava.threadstu;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.huang.hqjava.threadstu
 * @Description:
 * @date 2017/4/4 21:32
 * @Company:
 */
public class CyclicbarrieTest {

    static class Worker implements Runnable {

        private CyclicBarrier cb; //关卡

        public Worker(CyclicBarrier _cb) {
            cb = _cb;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(new Random().nextInt(1000));
                System.out.println(Thread.currentThread().getName() + " - 到达汇合点.");
                cb.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //设置汇集数量,以及汇集完成
        CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("任务完成了....");
            }
        });
        new Thread(new Worker(cb),"工人1").start();
        new Thread(new Worker(cb),"工人2").start();
        new Thread(new Worker(cb),"工人3").start();
    }

}
