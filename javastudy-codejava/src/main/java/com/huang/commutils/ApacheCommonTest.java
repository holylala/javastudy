package com.huang.commutils;

import org.apache.commons.beanutils.*;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.mutable.MutableInt;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.huang.commutils
 * @Description:
 * @date 2017/4/10 15:14
 * @Company: creditease.cn
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


    }

}
