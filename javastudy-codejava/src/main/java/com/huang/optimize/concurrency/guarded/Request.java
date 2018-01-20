package com.huang.optimize.concurrency.guarded;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.huang.optimize.concurrency.guarded
 * @Description:
 * @date 2018/1/20 23:47
 * @Company:
 */
public class Request {

    private String name;

    public Request(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
