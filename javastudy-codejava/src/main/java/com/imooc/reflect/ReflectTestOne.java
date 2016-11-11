package com.imooc.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.imooc.reflect
 * @Description:
 * @date 2016/11/10 17:25
 * @Company: creditease.cn
 */
public class ReflectTestOne {

    public final void doSometing() {
        System.out.println("Do someting !!!");
    }

    public final void needCheck() {
        System.out.println("忽略检查才能执行的方法。");
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method m1 = ReflectTestOne.class.getMethod("doSometing");
        //可以设置该属性值为 true 代表需要进行安全检查
        System.out.println("是否可以忽略安全检查:>>>" + m1.isAccessible());
        m1.invoke(new ReflectTestOne());

        Method m2 = ReflectTestOne.class.getMethod("needCheck");
        //标准写法 代表忽略安全检查 提高执行速度
        if (!m2.isAccessible()) {
            m2.setAccessible(true);
        }
        m2.invoke(new ReflectTestOne());

    }

}
