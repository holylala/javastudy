package com.huang.imooc.proxy.myproxy;

import java.lang.reflect.Method;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.huang.imooc.proxy.myproxy
 * @Description:
 * @date 2018/1/31 23:34
 * @Company:
 */
public interface InvocationHandler {
    //有参数 可以设置传递参数
    public void invoke(Object o,Method m);
}
