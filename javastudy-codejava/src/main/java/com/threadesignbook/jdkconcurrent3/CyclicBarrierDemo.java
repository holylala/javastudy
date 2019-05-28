package com.threadesignbook.jdkconcurrent3;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.threadesignbook.jdkconcurrent3
 * @Description:
 * @date 2019/5/1 22:43
 * @Company:
 */
public class CyclicBarrierDemo {

    public static class Soldier implements Runnable {

        private String soldierName;
        private final CyclicBarrier cyclicBarrier;

        public Soldier(CyclicBarrier cyclicBarrier, String soldierName) {
            this.cyclicBarrier = cyclicBarrier;
            this.soldierName = soldierName;
        }

        @Override
        public void run() {
            try {
                cyclicBarrier.await();//等待所有士兵到齐
                doWork();
                cyclicBarrier.await();//等待所有士兵完成工作
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        void doWork() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt()%10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(soldierName + ": 任务完成!");
        }
    }

    public static class BarrierRun implements Runnable { //每一次计数结束 执行

        boolean flag;
        int N;

        public BarrierRun(boolean flag, int N) {
            this.flag = flag;
            this.N = N;
        }

        @Override
        public void run() {
            if (flag) {
                System.out.println("司令:[士兵" + N + "个,任务完成!]");
            } else {
                System.out.println("司令:[士兵" + N + "个,集合完毕!]");
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
        final int N = 10;
        Thread[] allSoldier = new Thread[N];
        boolean flag = false;
        CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierRun(flag, N));
        System.out.println("集合队伍:>>>");
        for (int i = 0; i < N; ++i) {
            if (i == 5) {
                allSoldier[0].interrupt();
            }
            System.out.println("士兵" + i + " 报道! ");
            allSoldier[i] = new Thread(new Soldier(cyclic, "士兵 "+ i));
            allSoldier[i].start();
        }
    }

}
