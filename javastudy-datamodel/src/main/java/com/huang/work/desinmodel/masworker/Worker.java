package com.huang.work.desinmodel.masworker;

import java.util.Map;
import java.util.Queue;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.huang.work.desinmodel.masworker
 * @Description:
 * @date 2016/2/23 16:20
 * @Company: a
 */
public class Worker implements  Runnable {

    //任务队列,用于获得子任务
    protected Queue<Object> workQueue;

    //子任务处理结果集
    protected Map<String,Object> resultMap;

    public void setWorkQueue(Queue<Object> workQueue) {
        this.workQueue = workQueue;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    //子任务处理的逻辑,在子类中实现具体逻辑
    public Object handle(Object input) {
        return input;
    }

    @Override
    public void run() {
        while (true) {
            //获得子任务
            Object input = workQueue.poll();
            if (input == null) {
                break;
            }
            //处理子任务
            Object re = handle(input);
            //把处理结果写入结果集
            resultMap.put(Integer.toString(input.hashCode()),re);
        }
    }
}
