package com.huang.hqjava.datastrut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.huang.hqjava.datastrut
 * @Description:
 * @date 2016/4/6 16:37
 * @Company: creditease.cn
 */
public class SubListTest {

    public static void main(String[] args) {

        List<String> c = new ArrayList<String>();
        c.add("A");
        c.add("B");

        List<String> d = new ArrayList<String>(c);

        List<String> f =  c.subList(0,c.size());//f 列表 只是 c列表的一个视图,所有的修改操作都作用于原列表
        f.add("C");

        System.out.println("c == d ? "+c.equals(d)); //false

        System.out.println("c == f ? "+c.equals(f)); //true

        for (int i = 0, size = c.size(); i < size; i++) {
            System.out.println("c:>>"+c.get(i));
        }

        for (int i = 0, size = f.size(); i < size; i++) {
            System.out.println("f:>>"+f.get(i));
        }

    }

    public static void delSubList() {
        List<Integer> initData = Collections.nCopies(100,0); //初始化一个固定长度,不可变列表
        //转换成可变列表
        ArrayList<Integer> list = new ArrayList<Integer>(initData);
        //删除指定范围的元素
        list.subList(20,30).clear();
    }

    public static void subListReadOrWrite() {
        List<String> list = new ArrayList<String>();
        List<String> sublist = list.subList(0,2); //如果此时对list进行add操作 则sublist的方法会报错
        //把列表设置为只读状态
        list = Collections.unmodifiableList(list);
        //对list进行只读操作
        //对sublist进行读写操作
        //使用sublist生成子list之后,原list要保持只读状态
    }


}
