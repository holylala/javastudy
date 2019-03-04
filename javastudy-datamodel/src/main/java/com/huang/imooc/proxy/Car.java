package com.huang.imooc.proxy;

import java.util.Random;

public class Car implements Moveable {

	@Override
	public void move() {
		//实现开车
		try {
			Thread.sleep(new Random().nextInt(10000));
			System.out.println("汽车行驶中....");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//@Override
	public String moveWithName(String branName) {
		//实现开车
		try {
			Thread.sleep(new Random().nextInt(10000));
			System.out.println(branName + " car gogo行驶中....");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "I am " + branName;
	}

}
