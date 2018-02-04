package com.huang.imooc.singleton;

/**
 * @author huangzhenqiong@sina.cn
 * @version V1.0
 * @Package com.huang.imooc.singleton
 * @Description:
 * @date 2018/2/2 0:13
 * @Company:
 */
public class RunMain {
    public static void main(String[] args) {
        //饿汉模式
        Singleton s1=Singleton.getInstance();
        Singleton s2=Singleton.getInstance();
        if(s1==s2){
            System.out.println("s1和s2是同一个实例");
        }else{
            System.out.println("s1和s2不是同一个实例");
        }

        //懒汉模式
        Singleton2 s3=Singleton2.getInstance();
        Singleton2 s4=Singleton2.getInstance();
        if(s3==s4){
            System.out.println("s3和s4是同一个实例");
        }else{
            System.out.println("S3和s4不是同一个实例");
        }

    }
}
