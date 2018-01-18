package com.huang.optimize.concurrency.Future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.huang.optimize.concurrency.Future
 * @Description:
 * @date 2018/1/18 17:05
 * @Company: creditease.cn
 */
public class RunMain {


	public static void main(String[] args) throws Exception {

		FutureTask<String> futureTask = new FutureTask<String>(new RealData("a"));

		ExecutorService executorService = Executors.newFixedThreadPool(1);
		//开启线程进行 RealData 的 call() 执行
		executorService.submit(futureTask);

		System.out.println("请求完成.....");


		try {
			System.out.println("进行其他操作");
			Thread.sleep(2000);
			System.out.println("其他操作完成");
		} catch (Exception e) {

		}

		//如果此时RealData 的 call() 方法没有执行完成, 则依然会等待
		System.out.println("获取最后的数据:>>>"+futureTask.get());

	}

}
