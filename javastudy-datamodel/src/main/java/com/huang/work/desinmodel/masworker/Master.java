package com.huang.work.desinmodel.masworker;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.huang.work.desinmodel.masworker
 * @Description:
 * @date 2016/2/23 15:56
 * @Company: a
 */
public class Master {

    //任务队列
    protected Queue<Object> workQueue = new ConcurrentLinkedQueue<Object>();
    //worker 进程队列
    protected Map<String,Thread> threadMap = new HashMap<String,Thread>();
    //子任务处理结果集
    protected Map<String,Object> resultMap = new ConcurrentHashMap<String,Object>();

    public Master(Worker worker,int countWorker) {
        worker.setWorkQueue(workQueue);
        worker.setResultMap(resultMap);
        for(int i = 0; i < countWorker; i++) {
            threadMap.put(Integer.toString(i),new Thread(worker,Integer.toString(i)));
        }
    }

    //是否所有的子任务都结束了
    public boolean isComplete() {
        for(Map.Entry<String,Thread> entry : threadMap.entrySet()) {
            if (entry.getValue().getState() != Thread.State.TERMINATED) {
                return false;
            }
        }
        return true;
    }

    //提交一个任务
    public void submit(Object job) {
        workQueue.add(job);
    }

    //返回子任务结果集
    public Map<String,Object> getResultMap() {
        return resultMap;
    }

    //开始运行所有的work进程,进行处理
    public void execute() {
        for(Map.Entry<String,Thread> entry : threadMap.entrySet()) {
            entry.getValue().start();
        }
    }

}
