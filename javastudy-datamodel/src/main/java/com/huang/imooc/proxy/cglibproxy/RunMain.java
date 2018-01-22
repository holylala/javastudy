package com.huang.imooc.proxy.cglibproxy;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.huang.imooc.proxy.cglibproxy
 * @Description:
 * @date 2018/1/22 22:44
 * @Company:
 */
public class RunMain {

    public static void main(String[] args) {

        CglibProxy proxy = new CglibProxy();
        Train t = (Train)proxy.getProxy(Train.class);
        t.move();
    }

}
