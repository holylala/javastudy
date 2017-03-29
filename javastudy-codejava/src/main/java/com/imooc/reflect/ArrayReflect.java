package com.imooc.reflect;

import java.lang.reflect.Array;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.imooc.reflect
 * @Description: 动态创建数组
 * @date 2016/11/11 11:43
 * @Company: creditease.cn
 */
public class ArrayReflect {

    public static void main(String[] args) {
        //动态创建数组
        String[] strs = (String[]) Array.newInstance(String.class,8);
        //创建多维数组
        int[][] ints = (int[][]) Array.newInstance(int.class,2,3);
    }

}
