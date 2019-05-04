package com.huang.iodemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 流行的NIO框架 Netty , Apache MINA
public class NioServer {

    private static Charset charset = Charset.forName("UTF-8");
    private static CharsetDecoder decoder = charset.newDecoder();

    public static void main(String[] args) throws IOException {

        //创建一个 selector
        Selector selector = Selector.open();

        //创建channel
        ServerSocketChannel ssc = ServerSocketChannel.open();
        int port = 9211;
        ssc.bind(new InetSocketAddress(port));//绑定端口
        //非阻塞
        ssc.configureBlocking(false);
        //向selector注册,监听连接
        ssc.register(selector,SelectionKey.OP_ACCEPT);

        //连接计数
        int connectionCount = 0;

        //处理的线程
        int threads = 3;
        ExecutorService tpool = Executors.newFixedThreadPool(threads);

        while (true) {
            //阻塞等待就绪的事件
            int readyChannelCount = selector.select();
            if (readyChannelCount == 0) {
                continue;
            }
            //得到就绪的channel的key
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();

            while (keyIterator.hasNext()) {

                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel)key.channel();
                    SocketChannel sc = serverSocketChannel.accept();
                    sc.configureBlocking(false);
                    sc.register(selector,SelectionKey.OP_READ,++connectionCount);
                } else if (key.isConnectable()) {

                } else if (key.isReadable()) {
                    tpool.execute(new SocketProcess(key));
                    key.cancel();
                } else if (key.isWritable()) {

                }
                    keyIterator.remove();

            }
        }

    }

    static class SocketProcess implements Runnable {

        SelectionKey key;

        public SocketProcess(SelectionKey key) {
            this.key = key;
        }

        @Override
        public void run() {
            try {
                System.out.println("连接 " + key.attachment() + " 发来了," + readFromChannel());
                key.channel().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String readFromChannel() throws IOException {
            SocketChannel socketChannel = (SocketChannel)key.channel();

            int bfsize = 1024;
            ByteBuffer rbf = ByteBuffer.allocateDirect(bfsize);//直接分配系统内存

            ByteBuffer bigBf = null;

            int count = 0;
            while ((socketChannel.read(rbf)) != -1) {
                count++;
                ByteBuffer temp = ByteBuffer.allocateDirect(bfsize * (count + 1));
                if (bigBf != null) {
                    bigBf.flip();//转成读模式
                    temp.put(bigBf);
                }
                bigBf = temp;
                //加入大buffer
                rbf.flip();
                bigBf.put(rbf);
                //为下次读 清理buffer
                rbf.clear();
            }
            if (bigBf != null) {
                bigBf.flip();
                try {
                    return decoder.decode(bigBf).toString();//字节转成字符 返回接收到的字符
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

    }

}
