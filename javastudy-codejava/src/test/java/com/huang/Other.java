package com.huang;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.huang
 * @Description:
 * @date 2016/4/19 16:58
 * @Company: a
 */
public class Other {

    public static void main(String[] args) {
        //        Calendar c = Calendar.getInstance(); //76213
//        c.set(Calendar.HOUR_OF_DAY, 21);
//        c.set(Calendar.MINUTE, 10);
//        Calendar now = Calendar.getInstance();
//        System.out.println("21点10分:"+c.getTimeInMillis()/1000);
//        //System.out.println("现在:"+1460044815000);
//        long extime = (c.getTimeInMillis() - 1460044815000l)/1000;
//        System.out.println("相差:"+extime);
    }


    private static void subListTest() {
        List<String> strList = new ArrayList<String>();
        strList.add("12");
        strList.add("33");
        strList.add("44");
        strList.add("77");
        strList.add("92");
        strList.add("62");
        strList.add("53");
        List<String> subList = strList.subList(9,10);

        for (String s: subList) {
            System.out.println(s);
        }
    }

}
