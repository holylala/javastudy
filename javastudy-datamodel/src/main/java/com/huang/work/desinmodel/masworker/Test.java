package com.huang.work.desinmodel.masworker;

import java.util.Map;
import java.util.Set;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.huang.work.desinmodel.masworker
 * @Description:
 * @date 2016/2/23 16:39
 * @Company: creditease.cn
 */
public class Test {

    public static void main(String[] args) {

        Master master = new Master(new PlusWorker(),5);
        //提交任务
        for (int i = 0; i <= 3; i++) {
            master.submit(i);
        }

        master.execute();

        //存放最后的结果
        int re = 0;

        Map<String,Object> resultMap = master.getResultMap();

        while(resultMap.size() > 0 || !master.isComplete()) {

            Set<String> keys = resultMap.keySet();
            String key = null;

            for(String k : keys) {
                key = k;
                break;
            }

            Integer i  = null;
            if (key != null) {
                i = (Integer)resultMap.get(key);
            }

            if (i != null) {
                re += i;
            }

            if (key != null) {
                resultMap.remove(key);
            }
        }
        System.out.println("final result:>>>"+re);
    }

}
