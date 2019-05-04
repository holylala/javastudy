package com.huang.iodemo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * BIO 同步阻塞IO
 */
public class BIOClient implements Runnable {

    private String host;
    private int port;

    private Charset charset = Charset.forName("UTF-8");

    public BIOClient(String host, int port) {
        super();
        this.host = host;
        this.port = port;
    }

    @Override
    public void run() {
        try (Socket s = new Socket(host,port); OutputStream out = s.getOutputStream();) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入:>>>>>");
            String mess = scanner.nextLine();
            out.write(mess.getBytes(charset));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BIOClient client = new BIOClient("127.0.0.1",9211);
        Thread thread = new Thread(client);
        thread.start();
    }

}
