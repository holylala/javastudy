package com.huang.hqjava.datastrut;

import java.util.*;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.huang.hqjava.datastrut
 * @Description:
 * @date 2016/4/4 17:35
 * @Company: a
 */
public class ListTest {
    public static void main(String[] args) {

        //listall();
        //retainAll();
        removeAll();
        //listallonly();
        //shuffe();
//        int stuNum = 80;
//        List<Integer> sores = new ArrayList<Integer>(stuNum);
//        for (int i = 0; i < stuNum ; i++) {
//            sores.add(new Random().nextInt(150));
//        }
//        average(sores);
    }

    private static void average(List<Integer> sores) {
        int sum = 0;
        if (sores instanceof RandomAccess) { //如果该列表有RandomAccess 随机读取的接口

            for (int i = 0, size = sores.size(); i < size; i++) { //这种方式快
                sum += sores.get(i);
            }

        } else {
            for(Integer value:sores) {
                sum += value;
            }
        }
        System.out.println(sum);
    }

    //集合的并集:
    private static void listall() {
        List<String> list1 = new ArrayList<String>();
        list1.add("A");
        list1.add("B");

        List<String> list2 = new ArrayList<String>();
        list2.add("C");
        list2.add("D");

        list1.addAll(list2);
        System.out.println(list1); // [A, B, C, D]
    }

    //集合的交集:
    private static void retainAll() {
        List<String> list1 = new ArrayList<String>();
        list1.add("A");
        list1.add("B");
        list1.add("C");

        List<String> list2 = new ArrayList<String>();
        list2.add("C");
        list2.add("D");

        list1.retainAll(list2);
        System.out.println(list1); // [C]
    }

    //集合的差集:
    private static void removeAll() {
        List<String> list1 = new ArrayList<String>();
        list1.add("A");
        list1.add("B");
        list1.add("C");

        List<String> list2 = new ArrayList<String>();
        list2.add("C");
        list2.add("D");

        list2.removeAll(list1);
        System.out.println(list2); // [D]
    }

    //无重复的并集

    private static void listallonly() {

        List<String> list1 = new ArrayList<String>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        List<String> list2 = new ArrayList<String>();
        list2.add("C");
        list2.add("D");

        list2.removeAll(list1);
        list1.addAll(list2);

        System.out.println(list1); // [A, B, C, D]
    }
    //打乱列表
    private static void shuffe() {

        int tagCloudNum = 10;

        List<String> tageClouds = new ArrayList<String>(tagCloudNum);
        tageClouds.add("java");
        tageClouds.add("php");
        tageClouds.add("roby");
        tageClouds.add("python");
        tageClouds.add("beijing");
        tageClouds.add("haikou");

        Collections.shuffle(tageClouds); // [haikou, roby, php, python, beijing, java]

        System.out.println(tageClouds);
    }

}
