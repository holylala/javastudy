package com.huang.hqjava.zhujie;

/**
 * Created by zhenqiong on 2016/5/29.
 */
public interface Person {


    public void sing();

    public void running();

    //该注解表示方法过时
    @Deprecated
    public void fucking();

}
