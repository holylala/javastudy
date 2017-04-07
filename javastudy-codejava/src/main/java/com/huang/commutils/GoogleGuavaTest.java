package com.huang.commutils;

import com.google.common.collect.*;

import java.util.Collection;
import java.util.List;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.huang.commutils
 * @Description: google工具集
 * @date 2017/4/7 16:43
 * @Company: creditease.cn
 */
public class GoogleGuavaTest {

    public void immuCollections() {
        //不可变列表
        ImmutableList<String> list1 = ImmutableList.of("A","B","C");
        //list1.add("D"); 会抛出异常 列表不可修改
        ImmutableMap<Integer,String> map = ImmutableMap.of(1,"one",2,"two");
        System.out.println(list1.size() + "," + list1.toString());

        //多值Map
        Multimap<String,String> phoneBook = ArrayListMultimap.create();
        phoneBook.put("huang","1110");
        phoneBook.put("huang","1119");
        Collection<String> twoList = phoneBook.get("huang");
        System.out.println(twoList);

        //table表
        Table<Double,Double,String> g = HashBasedTable.create();
        g.put(31.23,121.48,"人民广场");
        System.out.println(g.get(31.23,121.48));

    }

    public static void main(String[] args) {
        GoogleGuavaTest t = new GoogleGuavaTest();
        t.immuCollections();
    }

}
