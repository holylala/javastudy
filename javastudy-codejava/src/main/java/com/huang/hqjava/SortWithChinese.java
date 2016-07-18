package com.huang.hqjava;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.huang.hqjava
 * @Description:
 * @date 2016/3/30 15:36
 * @Company: creditease.cn
 */
public class SortWithChinese {

    /**
     *  李四(L)  ok
        王五(W)
        张三(Z)
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String[] strs = {"张三(Z)","李四(L)","王五(W)"};
        //可以使用该方法完成中文的简单排序,但是有些情况下不是严格的
        Comparator c = Collator.getInstance(Locale.CHINA);
        Arrays.sort(strs,c);
        for (String str : strs) {
            System.out.println(str);
        }
    }
}
