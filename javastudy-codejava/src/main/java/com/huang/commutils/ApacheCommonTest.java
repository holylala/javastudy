package com.huang.commutils;

import org.apache.commons.beanutils.*;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.bag.HashBag;
import org.apache.commons.collections.bidimap.TreeBidiMap;
import org.apache.commons.collections.list.LazyList;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.mutable.MutableInt;

import java.util.*;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.huang.commutils
 * @Description:
 * @date 2017/4/10 15:14
 * @Company: a
 */
public class ApacheCommonTest {

    //DateUtils DateFormatUtils ArrayUtils LocaleUtils NumberUtils
    public static void main(String[] args) {
        StringUtilsTest();
    }

    public static void StringUtilsTest() {

        System.out.println("is empty:>>" + StringUtils.isEmpty(""));

        System.out.println(StringUtils.isNumeric("aa22")); //是否是数字

        System.out.println(StringUtils.left("fabb",2));//最左边两个字符

        System.out.println(StringUtils.countMatches("aabbaaccaad","aa"));//统计字符串出现的次数

        StringEscapeUtils.escapeXml("");//转义XML标示

        System.out.println(RandomStringUtils.randomAlphabetic(10));//随机生成长度为10仅字母的字符串

        System.out.println(RandomStringUtils.randomAscii(10));//随机生成长度为10的ASCII字符串

        System.out.println(WordUtils.capitalize("aab bcd"));//首字母大写
    }

    public static void ObjectUtilsTest() {
       // ToStringBuilder
        // EqualsBuilder
        //HashCodeBuilder.reflectionHashCode(this);
    }

    public static void TypeMethodTest() {
        MutableInt mi = new MutableInt(10);
        mi.add(10); //20
        mi.increment();//+1
        mi.intValue();
    }

    public static void beanUtilsTest() {
        //PropertyUtils.copyProperties(bean1,bean2); 两个Bean属性拷贝
        Map<String,String> map = new HashMap<String,String>();
        map.put("name","zhangsan");
        //PropertyUtils.copyProperties(bean,map); //把Map中的值拷贝到bean上
    }

    //动态Bean
    public static void dynaBeanTest() throws Exception {
        //动态bean
        DynaProperty[] props = new DynaProperty[] {
          new DynaProperty("name",String.class),
          new DynaProperty("age",int.class)
        };
        BasicDynaClass dynaClass = new BasicDynaClass("people",null,props);
        DynaBean people = dynaClass.newInstance();
        people.set("name","huang");
        people.set("age",5);
        System.out.println(people.get("name")+":"+people.get("age"));

        //自由bean
        DynaBean user = new LazyDynaBean();
        user.set("name","LiLi");
        //属性类型为Map
        user.set("phoneNum","tel","021");
        user.set("phoneNum","mobile","138");
        //ArrayList
        user.set("address","0","上海");
        user.set("address","1","北京");

        //转换器
        //ConvertUtilsBean() 属性值统一加前缀
    }

    public static void collectionTest() {
        //可统计重复数据量
        Bag box = new HashBag(Arrays.asList("red","blue","black","blue"));
        box.add("blue",3);//新增三个蓝球
        box.size();//球总数 7
        box.getCount("blue");//蓝球数量5

        //把一个List包装成一个 lazy 类型 在集合中的元素被访问时才生成
        List<String> lazy = LazyList.decorate(new ArrayList(), new Factory() {
            @Override
            public Object create() {
                return "A";
            }
        });

        String obj = lazy.get(3);
        lazy.add("No 5 value");
        lazy.size();



        //双向Map key和value都唯一
        BidiMap bidiMap = new TreeBidiMap();
        bidiMap.put("1","one");
        bidiMap.get("1");
        bidiMap.get("one");

        bidiMap.removeValue("one");//删除键值对
    }



}
