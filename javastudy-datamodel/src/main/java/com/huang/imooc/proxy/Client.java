package com.huang.imooc.proxy;

public class Client {

	/**
	 * 测试类
	 */
	public static void main(String[] args) {

//		Car car = new Car();
//		car.move();

		//使用继承的方式
//		Moveable m = new TimeCounter1();
//		m.move();
		//使用聚合方式实现
		Car car = new Car();
		Moveable m1 = new TimeCounter2(car);
		m1.move();
	}

}
