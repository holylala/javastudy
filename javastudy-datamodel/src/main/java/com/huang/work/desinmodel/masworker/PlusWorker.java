package com.huang.work.desinmodel.masworker;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.huang.work.desinmodel.masworker
 * @Description:
 * @date 2016/2/23 16:35
 * @Company: a
 */
public class PlusWorker extends Worker {

    @Override
    public Object handle(Object input) {
        Integer i = (Integer)input;
        return i*i*i;
    }

}
