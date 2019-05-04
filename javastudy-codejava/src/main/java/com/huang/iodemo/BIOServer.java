package com.huang.iodemo;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class BIOServer {

    private static Charset charset = Charset.forName("UTF-8");

    public static void main(String[] args) {

        int port = 9211;

        try (ServerSocket ss = new ServerSocket(port)) {

            while (true) {
                try {
                    Socket s = ss.accept();//阻塞等待
                    BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream(),charset));
                    String mess = null;
                    while ((mess = reader.readLine()) != null) {//阻塞等待
                        System.out.println("获取客户端消息:>>>" + mess);
                    }
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
