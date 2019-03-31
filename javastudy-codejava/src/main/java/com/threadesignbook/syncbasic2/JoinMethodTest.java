package com.threadesignbook.syncbasic2;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.threadesignbook
 * @Description:
 * @date 2019/3/25 23:09
 * @Company:
 */
public class JoinMethodTest {

    public volatile static int i = 0;

    public static class AddThread extends Thread {
        @Override
        public void run() {
            for (i = 0;i < 1000000; i++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread addThread = new AddThread();
        addThread.start();
        addThread.join();//主线程等待AddThread执行完毕,跟着AddThread一起往前走
        //它让调用线程在当前线程对象上进行等待.当线程执行完成后,被等待的线程会在退出前调用
        //notifyAll()通知所有的等待线程继续执行。
        System.out.println(i);
    }
}
