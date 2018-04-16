package com.huang.optimize.concurrency.guarded;

import java.util.LinkedList;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.huang.optimize.concurrency.guarded
 * @Description:
 * @date 2018/1/20 23:50
 * @Company:
 */
public class RequestQueue {

    private LinkedList queue = new LinkedList();

    public synchronized Request getRequest() {
        while (queue.size() == 0) {
            try {
                wait(); //等待直到有新的Request加入
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return (Request)queue.remove();//返回队列中的第一个请求
    }

    public synchronized void addRequest(Request request) {
        queue.add(request);//加入新的Request请求
        notifyAll();//通知getRequest()方法
    }

}
