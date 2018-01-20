package com.huang.optimize.concurrency.guarded;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.huang.optimize.concurrency.guarded
 * @Description:
 * @date 2018/1/20 23:57
 * @Company:
 */
public class ServerThread extends Thread {

    private RequestQueue requestQueue;

    public ServerThread(RequestQueue requestQueue,String name) {
        super(name);
        this.requestQueue = requestQueue;
    }

    public void run() {
        while (true) {
            final Request request = requestQueue.getRequest();//得到请求
            try {
                Thread.sleep(1000);//处理请求耗时
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " handles " + request);
        }
    }

}
