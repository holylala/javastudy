package com.huang.imooc.proxy.myproxy;

import com.huang.imooc.proxy.Car;
import com.huang.imooc.proxy.Moveable;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.huang.imooc.proxy.myproxy
 * @Description:
 * @date 2018/1/31 23:43
 * @Company:
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Car car = new Car();
        InvocationHandler h = new TimeHandler(car);
        Moveable m = (Moveable)Proxy.newProxyInstance(Moveable.class,h);
        m.move();
    }

}
