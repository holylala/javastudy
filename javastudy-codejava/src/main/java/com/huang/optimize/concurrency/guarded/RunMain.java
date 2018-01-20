package com.huang.optimize.concurrency.guarded;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.huang.optimize.concurrency.guarded
 * @Description:
 * @date 2018/1/21 0:10
 * @Company:
 */
public class RunMain {

    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();//请求队列
        for (int i = 0; i < 1; i++) {//服务端线程开启
            new ServerThread(requestQueue,"ServerThread"+i).start();;
        }
        for (int i = 0; i < 1; i++) {//客户端线程开启
            new ClientThread(requestQueue,"ClientThread"+i).start();;
        }
    }

}
