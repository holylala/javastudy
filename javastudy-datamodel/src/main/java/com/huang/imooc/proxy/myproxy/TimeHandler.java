package com.huang.imooc.proxy.myproxy;

import java.lang.reflect.Method;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.huang.imooc.proxy.myproxy
 * @Description:
 * @date 2018/1/31 23:45
 * @Company:
 */
public class TimeHandler implements InvocationHandler {

    private Object target;

    public TimeHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public void invoke(Object o, Method m) {

        try {
            long starttime = System.currentTimeMillis();
            System.out.println("car begin....");
            m.invoke(target);
            long endtime = System.currentTimeMillis();
            System.out.println("car go over"
                    + (endtime - starttime) + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

