/**
 * 
 */
package com.huang.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**   
 * @Title: Watcher.java 
 * @Package com.huang.aop 
 * @Description:
 * @Copyright： Copyright(c)2015
 * @Company：Bjrun 
 * @author zhenqiong zhenqiong@run.com   
 * @date 2015-12-22 下午04:46:27 
 * @version V1.0   
 */
//定义切面 @Aspect
@Aspect
public class Watcher {
	
	//切点
	@Pointcut("execution(* com.huang.aop.Player.play(..))")
	public void performance() {//这个方法并不重要 只是作为@Pointcut注解的配置
		
	}
	@Before("performance()")
	public void takeSeats() {
		System.out.println("注解方式:找座位....");
	}
	@Before("performance()")
	public void turnOffThePhone() {
		System.out.println("注解方式:关手机....");
	}
	@AfterReturning("performance()")
	public void sayGood() {
		System.out.println("注解方式:鼓掌....");
	}
	@AfterThrowing("performance()")
	public void sayBad() {
		System.out.println("注解方式:倒喝彩....");
	}
	@Around("performance()")
	public void watch(ProceedingJoinPoint joinpoint) {
		try {
			
			System.out.println("around---找座位....");
			System.out.println("around---关手机....");
			
			long start = System.currentTimeMillis();
			
			joinpoint.proceed();
			
			long end = System.currentTimeMillis();
			
			System.out.println("around---鼓掌....");
			
			System.out.println("around---表演持续了:>>>"+(end-start));
			
		} catch (Throwable t) {
			System.out.println("around---倒喝彩....");
		}
	}
	
}
