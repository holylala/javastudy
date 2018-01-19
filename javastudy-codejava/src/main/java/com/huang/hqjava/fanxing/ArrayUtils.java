package com.huang.hqjava.fanxing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.huang.hqjava.fanxing
 * @Description:
 * @date 2016/11/2 17:48
 * @Company: a
 */
public class ArrayUtils {

    //把一个变长参数转变成列表,并且长度可变
    public static <T> List<T> asList(T...t) {
        List<T> list = new ArrayList<T>();
        Collections.addAll(list,t);
        return list;
    }

    public static <T> T[] toArray(List<T> list,Class<T> tClass) {
        //声明并初始化一个T类型的数组
        T[] t = (T[]) Array.newInstance(tClass,list.size());
        for (int i = 0,n = list.size(); i < n; i++ ) {
            t[i] = list.get(i);
        }
        return t;
    }

    public static void main(String[] args) {

        List<String> list1 = ArrayUtils.asList("A","B","C");
        System.out.println(list1);

        List<Integer> list2 = ArrayUtils.<Integer>asList(1,2,34,33);
        System.out.println(list2);

        List<Number> list3 = ArrayUtils.<Number>asList(1,2.23,34.11,33);
        System.out.println(list3);

    }

}
