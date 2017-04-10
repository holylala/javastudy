package com.huang.commutils;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;

import java.util.*;

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

        //集合工具类
        Map<String,Integer> user = new HashMap<String,Integer>();
        user.put("aa",24);
        user.put("bb",22);
        user.put("cc",15);
        //所有年龄大于20的
        Map<String,Integer> fiterMap = Maps.filterValues(user, new Predicate<Integer>() {
            @Override
            public boolean apply(Integer age) {
                return age > 20;
            }
        });
        System.out.println(fiterMap);

        //字符串操作
        Joiner joiner = Joiner.on(",");
        String joinStr = joiner.skipNulls().join("ok",null,"girl","you");
        System.out.println(joinStr);//ok,girl,you

        String spliStr = "hello,world,aa";
        for (String s : Splitter.on(",").split(spliStr)) {
            System.out.println(s);
        }
        //按照固定长度分隔
        for(String s : Splitter.fixedLength(2).split(spliStr)) {
            System.out.println(s);
        }
        //基本类型工具
        int[] ints = {11,23,45,66,44};
        System.out.println(Ints.max(ints)); //最大的值
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        ints = Ints.toArray(integerList);
        System.out.println(ints[0]);
    }

    public static void main(String[] args) {
        GoogleGuavaTest t = new GoogleGuavaTest();
        t.immuCollections();
    }

}
