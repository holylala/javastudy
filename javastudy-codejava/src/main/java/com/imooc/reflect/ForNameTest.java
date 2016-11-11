package com.imooc.reflect;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.imooc.reflect
 * @Description:
 * @date 2016/11/10 18:11
 * @Company: creditease.cn
 */
public class ForNameTest {

    static {
        System.out.println("静态代码执行....");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.imooc.reflect.ForNameTest");//类加载会执行 static段的代码
    }

}
