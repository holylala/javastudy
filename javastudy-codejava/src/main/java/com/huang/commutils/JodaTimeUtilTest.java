package com.huang.commutils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Hours;
import org.joda.time.MutableDateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;
import java.util.Locale;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.huang.commutils
 * @Description:
 * @date 2017/4/12 14:01
 * @Company: a
 */
public class JodaTimeUtilTest {

    public static void main(String[] args) {
        timeTest();
    }

    public static void timeTest() {
        /**
         * 星期三
         2017-04-12
         2017年4月12日
         */
        DateTime dt = new DateTime();
        System.out.println(dt.dayOfWeek().getAsText(Locale.CHINA));//输出英文星期
        System.out.println(dt.toLocalDate());//本地日期格式化
        System.out.println(dt.toString(DateTimeFormat.forPattern("yyyy年M月d日")));

        dt.plusHours(100).dayOfWeek();//加100小时后是星期几
        dt.plusDays(100).toLocalDate();//100天后的日期
        dt.minusYears(10).dayOfWeek().getAsText();//10年前的今天是星期几
        Hours.hoursBetween(dt,new DateTime("2020-12-12")).getHours();//两个日期间隔小时数

        //10年内的黑色星期五
        MutableDateTime mdt = new MutableDateTime(); //当前可变时间

        DateTime dt1 = new DateTime();
        DateTime destDateTime = dt1.plusYears(10); //10年后的日期

        while (mdt.isBefore(destDateTime)) {
            mdt.addDays(1);
            if (mdt.getDayOfMonth() == 13 && mdt.getDayOfWeek() == 5) {
                System.out.println("黑色星期五: " + mdt);
            }
        }

        //时区时间
        DateTime dt2  = new DateTime();
        System.out.println("伦敦:>>"+dt2.withZone(DateTimeZone.forID("Europe/London")));
        System.out.println("标准时间:>>"+ dt2.withZone(DateTimeZone.UTC));

        DateTime dt3 = new DateTime();
        Date jdkDate = dt3.toDate();//转为jdk的Date
        dt3 = new DateTime(jdkDate);
    }

}
