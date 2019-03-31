package com.threadesignbook.syncbasic2;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.threadesignbook
 * @Description:
 * @date 2019/3/14 23:21
 * @Company:
 */
public class CreateThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("other thread runnable...");
    }
}
