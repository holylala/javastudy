package com.huang.optimize.concurrency.mupliworker;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.huang.optimize.concurrency.mupliworker
 * @Description:
 * @date 2018/1/19 17:36
 * @Company: a
 */
public class PlusWorker extends MyWorker {

	//求立方和
	@Override
	public Object handle(Object input) {
		Integer i = (Integer)input;
		return  i*i*i;
	}
}
