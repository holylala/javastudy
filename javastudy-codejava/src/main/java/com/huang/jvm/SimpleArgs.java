package com.huang.jvm;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.huang.jvm
 * @Description:
 * @date 2018/4/14 18:08
 * @Company:
 */
public class SimpleArgs {

    public static void main(String[] args) {
        for (int i = 0 ; i < args.length ; i++) {
            System.out.println("参数" + (i+1) + ":" + args[i]);
        }
        System.out.println("-Xmx" + Runtime.getRuntime().maxMemory()/1000/1000+"M");
    }

}
