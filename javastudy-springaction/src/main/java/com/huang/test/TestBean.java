/**
 * 
 */
package com.huang.test;

import com.huang.ioc.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**   
 * @Title: TestBean.java 
 * @Package com.huang.test 
 * @Description: 
 * @Copyright： Copyright(c)2015
 * @Company：Bjrun 
 * @author zhenqiong zhenqiong@
 * @date 2015-12-4 下午03:51:53 
 * @version V1.0   
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestBean extends UnitTestBase {
	
	public TestBean() {
		//super("com/huang/resource/spring-ioc.xml");
		super("classpath*:spring-ioc.xml");
	}
	
	@Test
	public void test1() {
		Juggler huang = super.getBean("july");//huang
		huang.performer();
	}

	@Test
	public void test2() {
		PeticJuggler pj = super.getBean("peticJuggler");
		pj.performer();
	}
	
	@Test
	public void test3() {
		super.getBean("theStage");
	}
	
	@Test
	public void test4() {
		Ticket tk1 = super.getBean("ticket");
		Ticket tk2 = super.getBean("ticket");
		System.out.println(tk1);
		System.out.println(tk2);
	}
	
	@Test
	public void test5() {
		super.getBean("auditorium");
	}
	
	@Test
	public void test6() {
		Instrumentalist it = super.getBean("kenny2");
		it.performer();
	}
	
	@Test
	public void test7() {
		OneManBand it = super.getBean("onemanband");
		it.performer();
	}
	
	@Test
	public void test8() {
		SpElTest it = super.getBean("speltest");
		System.out.println("double:>>"+it.getDoublevalue());
		System.out.println("int:>>"+it.getIntvalue());
		System.out.println("str:>>"+it.getStrvalue());
		System.out.println("boolean:>>"+it.isBoolvalue());
		System.out.println("object:>>>");
		it.getInstrument().paly();
	}
	
	
}
