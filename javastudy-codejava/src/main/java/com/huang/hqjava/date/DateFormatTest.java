package com.huang.hqjava.date;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.huang.hqjava.date
 * @Description:
 * @date 2016/7/17 19:47
 * @Company: a
 */
public class DateFormatTest {

    public static void main(String[] args) {
        System.out.println("Date:>>>"+DateFormat.getDateInstance(DateFormat.DATE_FIELD).format(new Date()));
    }
}
