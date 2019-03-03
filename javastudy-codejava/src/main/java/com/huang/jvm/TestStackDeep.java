package com.huang.jvm;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.huang.jvm
 * @Description:
 * @date 2018/5/30 23:49
 * @Company:
 */
public class TestStackDeep {

    private static int count = 0;

    public static void recursion() {
        count++;
        recursion();
    }

    public static void main(String[] args) {
        try {
            recursion();
        } catch (Throwable e) {
            System.out.println("deep of calling =" + count);
            e.printStackTrace();
        }
    }

}
