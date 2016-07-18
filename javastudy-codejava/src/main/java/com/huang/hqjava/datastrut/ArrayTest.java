package com.huang.hqjava.datastrut;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.huang.hqjava.datastrut
 * @Description:
 * @date 2016/3/31 11:26
 * @Company: creditease.cn
 */
public class ArrayTest {

    //数组扩容
    public static <T> T[] expandCapacity(T[] datas, int newLen) {
        newLen = newLen < 0 ? 0:newLen;
        return Arrays.copyOf(datas,newLen);//此拷贝是浅拷贝
    }

    //找最大值
    public static int max(int[] data) {
        Arrays.sort(data.clone()); //先克隆 这样不改原有数组的顺序
        return data[data.length - 1];
    }

    //取倒数第二个最大值
    public static int getSecondMax(Integer[] data) {
        List<Integer> dataList = Arrays.asList(data); //转成List
        TreeSet<Integer> ts = new TreeSet<Integer>(dataList);//转成TreeSet 删除重复元素并且升序排列
        return ts.lower(ts.last()); //取倒数第二个最大值
    }

    public static void main(String[] args) {

        Student[] classes = new Student[60];
        System.out.println(classes.length); //60
        classes = expandCapacity(classes,80);
        System.out.println(classes.length);//80

    }
}
