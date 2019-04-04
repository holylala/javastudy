package com.huang.iodemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class BIOServerMupliThread {

    private static Charset charset = Charset.forName("UTF-8");

    public static void main(String[] args) {

        int port = 9211;

        try (ServerSocket ss = new ServerSocket(port);) {

            while (true) {
                Socket s = ss.accept();
                //新开一个线程去处理这个连接
                new Thread(new SocketProcess(s)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SocketProcess implements Runnable {

        Socket s;

        public SocketProcess(Socket s) {
            this.s = s;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream(),charset));) {
                String mess = null;
                while ((mess = reader.readLine()) != null) {//阻塞等待
                    System.out.println("获取客户端消息:>>>" + mess);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
