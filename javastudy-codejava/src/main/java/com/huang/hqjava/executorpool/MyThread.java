package com.huang.hqjava.executorpool;

/**
 * @author zhenqionghuang
 * @version V1.0
 * @Package com.huang.hqjava.executorpool
 * @Description:
 * @date 2018/1/26 16:11
 * @Company:
 */
public class MyThread implements Runnable, Comparable<MyThread> {

	protected String name;

	public MyThread() {

	}

	public MyThread(String name) {
		this.name = name;
	}


	@Override
	public void run() {
		try {
			Thread.sleep(100);
			System.out.println(name+",Complete.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int compareTo(MyThread o) {

		int me = Integer.parseInt(this.name.split("_")[1]);
		int other = Integer.parseInt(o.name.split("_")[1]);

		if (me > other) return  1;
		else if (me < other) return  -1;
		else
			return  0;

	}


}
