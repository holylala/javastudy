package com.huang.hqjava.objectclone;

import org.apache.commons.lang.SerializationUtils;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.huang.hqjava.objectclone
 * @Description:
 * @date 2016/3/22 18:27
 * @Company: creditease.cn
 */
public class ClientTest {

    public static void main(String[] args) {



        Person f = new Person("父亲");

        Person son1 = new Person("大儿子", f);

        //可以使用 Apache commons 中的 SerializationUtils.clone 序列化方法深度拷贝对象
        Person son2 = (Person)SerializationUtils.clone(son1);

       // Person son2 = son1.clone(); 浅拷贝
        son2.setName("小儿子");

       son1.getFather().setName("干爹");//浅拷贝的情况下 son1 和 son2 都是一样的结果

        System.out.println(son1.getName() + " 的父亲是 " + son1.getFather().getName());
        System.out.println(son2.getName() + " 的父亲是 " + son2.getFather().getName());
    }


}
