package com.huang.imooc.proxy;

//使用聚合方式实现静态代理
public class TimeCounter2 implements Moveable {

	public TimeCounter2(Car car) {
		super();
		this.car = car;
	}
	//聚合
	private Car car;

	@Override
	public void move() {
		long starttime = System.currentTimeMillis();
		System.out.println("汽车开始行驶....");
		car.move();
		long endtime = System.currentTimeMillis();
		System.out.println("汽车结束行驶....  汽车行驶时间："
				+ (endtime - starttime) + "毫秒！");
	}

	//@Override
	public String moveWithName(String branName) {
		return null;
	}

}
