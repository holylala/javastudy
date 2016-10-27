package com.huang.work.desinmodel.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.huang.work.desinmodel.proxy
 * @Description: cglib 实现动态代理
 * @date 2016/10/27 17:59
 * @Company: creditease.cn
 */
public class CglibDbQueryInterceptor implements MethodInterceptor {

    IDBQuery real = null;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (real == null) {
            real = new DBQuery();
        }
        return real.request();
    }
}
