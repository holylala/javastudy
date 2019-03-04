package com.huang.imooc.proxy;

public class Client {

	/**
	 * 静态代理测试类
	 */
	public static void main(String[] args) {

//		Car car = new Car();
//		car.move();

		//使用继承的方式
//		Moveable m = new TimeCounter1();
//		m.move();

		//使用聚合方式实现
//		Car car = new Car();
//		Moveable m1 = new TimeCounter2(car);
//		m1.move();

		//聚合方式实现代理功能的叠加

		Car car = new Car();
		CarLogProxy clp = new CarLogProxy(car);
		CarTimeProxy ctp = new CarTimeProxy(clp);
		ctp.move();
	}

}
