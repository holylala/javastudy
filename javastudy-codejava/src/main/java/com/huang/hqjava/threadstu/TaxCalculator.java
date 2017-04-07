package com.huang.hqjava.threadstu;

import java.util.concurrent.*;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.huang.hqjava.threadstu
 * @Description:
 * @date 2017/3/31 15:07
 * @Company: creditease.cn
 */
public class TaxCalculator implements Callable<Integer> {


    private int seedMoney;

    public TaxCalculator(int _seedMoney) {
        seedMoney = _seedMoney;
    }

    @Override
    public Integer call() throws Exception {

        TimeUnit.MILLISECONDS.sleep(10000); //耗时10秒

        return seedMoney / 10;
    }

    public static void main(String[] args) throws Exception {

        ExecutorService es = Executors.newSingleThreadExecutor(); //一个单线程的异步执行器

        Future<Integer> future = es.submit(new TaxCalculator(100)); //线程执行后的结果

        while (!future.isDone()) { //如果还没有执行完
            TimeUnit.MILLISECONDS.sleep(200);
            System.out.print("#");
        }

        System.out.println("\n 线程执行完成, 结果:>>>" + future.get() + " .");
        es.shutdown();

    }

}
