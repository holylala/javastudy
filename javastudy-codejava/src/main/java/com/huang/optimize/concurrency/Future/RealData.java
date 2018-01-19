package com.huang.optimize.concurrency.Future;

import java.util.concurrent.Callable;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.huang.optimize.concurrency.Future
 * @Description:
 * @date 2017/12/21 18:28
 * @Company: a
 */
public class RealData implements Callable<String> {

	private String para;

	public RealData(String para) {
		this.para = para;
	}

	@Override
	public String call() throws Exception {
		//真实的业务逻辑 其执行可能很慢
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 100; i++) {
			sb.append(para);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

			}
		}
		return sb.toString();
	}
}
