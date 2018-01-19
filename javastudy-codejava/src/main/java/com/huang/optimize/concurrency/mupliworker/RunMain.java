package com.huang.optimize.concurrency.mupliworker;

import java.util.Map;
import java.util.Set;

/**
 * @author zhenqionghuang
 * @version V1.0
 * @Package com.huang.optimize.concurrency.mupliworker
 * @Description:
 * @date 2018/1/19 17:38
 * @Company:
 */
public class RunMain {

	public static void main(String[] args) {

		Master m = new Master(new PlusWorker(),5);
		for (int i = 0; i < 100; i++) {
			m.submit(i); //提交子任务
		}
		m.execute(); //开始计算

		int lastResult = 0;

		Map<String,Object> resultMap = m.getResultMap();

		while (resultMap.size() > 0 || !m.isComplete()) {
			Set<String> keys = resultMap.keySet();

			String key = null;

			for (String k : keys) {
				key = k;
				break;
			}

			Integer i = null;
			if (key != null) {
				i = (Integer)resultMap.get(key);
			}
			if (i != null) {
				lastResult += i;
			}

			if (key != null) {
				resultMap.remove(key);
			}
			System.out.println("No."+i+",result:>>"+lastResult);
		}

		System.out.println("last result:>>>" + lastResult);

	}
}
