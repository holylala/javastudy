package com.huang.hqjava.datastrut;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.huang.hqjava.datastrut
 * @Description:
 * @date 2016/4/1 17:03
 * @Company: creditease.cn
 */
public class ArraysTest {

    public static void main(String[] args) {
        //数组转列表 注意 元素必须是 包装类 否则 dataList.size == 1
        Integer[] data = {1,3,56,44,55,34};
        List<Integer> dataList = Arrays.asList(data);//元素的引用没有变
        System.out.println(dataList.size());
        Integer one = dataList.get(0);
        one = 99;
        dataList.set(0,one);
        System.out.println(dataList.get(0));//99
        System.out.println(data[0]);//99

        dataList.add(77); //不能添加元素, Arrays.asList 该方法的返回List 不能改变大小
    }

}
