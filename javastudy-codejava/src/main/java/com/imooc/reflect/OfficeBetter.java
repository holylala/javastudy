package com.imooc.reflect;


public class OfficeBetter {

	public static void main(String[] args) {
		//new 创建对象 是静态加载类 在编译时就需要加载所有的可能使用到的类
		//可通过动态加载类可以解决该问题
		try {
			//可通过编译javac 在运行时java 可以动态加载类
			Class<?> c  = Class.forName(args[0]);
			//通过类类型创建该类对象
			//提供一个统一的标准(接口) 这样只要是实现这个接口的类都能创建出对应的对象 同时OfficeBetter也减少了编译
			OfficeAble oa = (OfficeAble)c.newInstance();
			oa.start();
		} catch (Exception e) {
		}
		
	}

}
