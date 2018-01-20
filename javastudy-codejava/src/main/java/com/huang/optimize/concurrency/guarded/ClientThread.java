package com.huang.optimize.concurrency.guarded;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.huang.optimize.concurrency.guarded
 * @Description:
 * @date 2018/1/21 0:03
 * @Company:
 */
public class ClientThread extends Thread {

    private RequestQueue requestQueue;

    public ClientThread(RequestQueue requestQueue,String name) {
        super(name);
        this.requestQueue = requestQueue;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            //构造请求
            Request request = new Request("RequestId:"+i+" Thread Name:"+Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + " requests " + request);
            //提交请求
            requestQueue.addRequest(request);
            try { //客户端请求速度快于服务端处理的速度
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ClientThread Name is :"+ Thread.currentThread().getName());
        }
        System.out.println(Thread.currentThread().getName() + " request over");
    }

}
