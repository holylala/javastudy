package com.huang.hqjava.threadstu;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.huang.hqjava.threadstu
 * @Description: 使用线程异常处理器
 * @date 2017/3/30 18:36
 * @Company: a
 */
public class TcpServer implements Runnable {

    public TcpServer() {
        Thread t = new Thread(this);
        t.setUncaughtExceptionHandler(new TcpServerExceptionHandler());//指定一个异常处理器
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(" 系统正常运行 :" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //抛出异常
        throw new RuntimeException();
    }

    //异常处理
    private static class TcpServerExceptionHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("线程 " + t.getName() + " 出现异常,自行重启");
            e.printStackTrace();
            new TcpServer(); //重启服务
        }
    }

    public static void main(String[] args) {
        new TcpServer();
    }

}
