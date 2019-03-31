package com.threadesignbook.syncbasic2;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.threadesignbook
 * @Description:
 * @date 2019/3/30 22:28
 * @Company:
 */
public class DaemonThreadDemo {

    public static class DaemonT extends Thread {
        public void run() {
            while (true) {
                System.out.println("I am alive");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t = new DaemonT();
        t.setDaemon(true);//需要在 t.start()方法执行前 设置 因为是守护线程
        // main线程执行完 则结束执行,如果不设置 该线程为业务线程 会一直执行下去
        t.start();
        Thread.sleep(3000);
    }


}
