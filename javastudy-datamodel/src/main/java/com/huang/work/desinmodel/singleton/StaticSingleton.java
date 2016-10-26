/**
 * 
 */
package com.huang.work.desinmodel.singleton;

/**
 *
 */
public class StaticSingleton {  
	
	private StaticSingleton() {
		System.out.println("  StaticSingleton 调用 ");
	}
	
	private static class StaticInnerClass {

	   private static StaticSingleton instance = new StaticSingleton();
    }
	
	public static StaticSingleton getInstance() {
		return StaticInnerClass.instance;
	}
	
	
}  
	
