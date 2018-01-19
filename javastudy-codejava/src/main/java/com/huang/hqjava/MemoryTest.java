package com.huang.hqjava;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.huang.hqjava
 * @Description:
 * @date 2016/7/6 15:49
 * @Company: a
 */
public class MemoryTest {

    public static void main(String[] args) {

        final Runtime rt = Runtime.getRuntime();
        StringBuffer sb  = new StringBuffer();

        long heapMaxSize = rt.maxMemory() >> 20;
        sb.append("最大可用内存: " + heapMaxSize + "M\n");

        long total = rt.totalMemory() >> 20;
        sb.append("堆内存大小:" + total + "M\n");

        long free = rt.freeMemory() >> 20;
        sb.append("空闲内存:" + free + "M\n" );

        System.out.println(sb);

    }

}
