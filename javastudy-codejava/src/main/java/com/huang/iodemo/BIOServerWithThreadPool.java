package com.huang.iodemo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServerWithThreadPool {

    private static Charset charset = Charset.forName("UTF-8");

    public static void main(String[] args) {
        int port = 9211;
        int threadCount = 100;
        ExecutorService tpool = Executors.newFixedThreadPool(threadCount);

        try (ServerSocket ss = new ServerSocket(port);) {

            while (true) {
                Socket s = ss.accept();
                //放入线程池
                tpool.execute(new BIOServerMupliThread.SocketProcess(s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        tpool.shutdown();

    }

}
