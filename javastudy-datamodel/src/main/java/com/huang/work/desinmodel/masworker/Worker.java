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

    //�������,���ڻ��������
    protected Queue<Object> workQueue;

    //������������
    protected Map<String,Object> resultMap;

    public void setWorkQueue(Queue<Object> workQueue) {
        this.workQueue = workQueue;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    //����������߼�,��������ʵ�־����߼�
    public Object handle(Object input) {
        return input;
    }

    @Override
    public void run() {
        while (true) {
            //���������
            Object input = workQueue.poll();
            if (input == null) {
                break;
            }
            //����������
            Object re = handle(input);
            //�Ѵ�����д������
            resultMap.put(Integer.toString(input.hashCode()),re);
        }
    }
}
