package com.huang.imooc.proxy;

//使用继承实现代理 TimeCounter1 是 Car 的代理
public class TimeCounter1 extends Car {

	@Override
	public void move() {
		long starttime = System.currentTimeMillis();
		System.out.println("汽车开始行驶....");
		super.move();
		long endtime = System.currentTimeMillis();
		System.out.println("汽车结束行驶....  汽车行驶时间："
				+ (endtime - starttime) + "毫秒！");
	}
}
