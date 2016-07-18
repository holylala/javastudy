package com.huang.work.desinmodel.masworker;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.huang.work.desinmodel.masworker
 * @Description:
 * @date 2016/2/23 15:56
 * @Company: creditease.cn
 */
public class Master {

    //�������
    protected Queue<Object> workQueue = new ConcurrentLinkedQueue<Object>();
    //worker ���̶���
    protected Map<String,Thread> threadMap = new HashMap<String,Thread>();
    //������������
    protected Map<String,Object> resultMap = new ConcurrentHashMap<String,Object>();

    public Master(Worker worker,int countWorker) {
        worker.setWorkQueue(workQueue);
        worker.setResultMap(resultMap);
        for(int i = 0; i < countWorker; i++) {
            threadMap.put(Integer.toString(i),new Thread(worker,Integer.toString(i)));
        }
    }

    //�Ƿ����е������񶼽�����
    public boolean isComplete() {
        for(Map.Entry<String,Thread> entry : threadMap.entrySet()) {
            if (entry.getValue().getState() != Thread.State.TERMINATED) {
                return false;
            }
        }
        return true;
    }

    //�ύһ������
    public void submit(Object job) {
        workQueue.add(job);
    }

    //��������������
    public Map<String,Object> getResultMap() {
        return resultMap;
    }

    //��ʼ�������е�work����,���д���
    public void execute() {
        for(Map.Entry<String,Thread> entry : threadMap.entrySet()) {
            entry.getValue().start();
        }
    }

}
