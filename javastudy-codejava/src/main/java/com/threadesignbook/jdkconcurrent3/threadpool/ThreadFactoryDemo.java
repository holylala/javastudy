package com.threadesignbook.jdkconcurrent3.threadpool;

import java.util.concurrent.*;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.threadesignbook.jdkconcurrent3.threadpool
 * @Description:
 * @date 2019/5/26 22:29
 * @Company:
 */
public class ThreadFactoryDemo {

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

    public static void main(String[] args) throws Exception {

        MyTask task = new MyTask();

        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(), new ThreadFactory() {

            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true);//守护线程 当主线程退出后 将会强制销毁线程池
                System.out.println("create " + t.getId());
                return t;
            }

        });

        for (int i = 0; i < 5; i++) {
            es.submit(task);
        }

        Thread.sleep(2000);

    }

}
