package com.threadesignbook.jdkconcurrent3.threadpool;

import java.util.concurrent.*;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.threadesignbook.jdkconcurrent3.threadpool
 * @Description:
 * @date 2019/5/18 23:49
 * @Company:
 */
public class RejectThreadPoolDemo {

    public static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread ID:" + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();

        /**
        ThreadPoolExecutor(int corePoolSize,
        int maximumPoolSize,
        long keepAliveTime,
        TimeUnit unit,
        BlockingQueue<Runnable> workQueue,
        ThreadFactory threadFactory,
        RejectedExecutionHandler handler)
        */

        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(10),
                Executors.defaultThreadFactory(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(r.toString() + " 被拒绝.");
                    }
                }
        );
        for (int i = 0; i < 100; i++) {
            es.execute(task);
            Thread.sleep(10);
        }
        es.shutdown();
    }
}
