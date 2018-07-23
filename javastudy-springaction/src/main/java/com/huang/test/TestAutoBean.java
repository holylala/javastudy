/**
 * 
 */
package com.huang.test;

import com.huang.autoioc.Car;
import com.huang.autoiocmore.Child;
import com.huang.autoiocmore.Zooker;
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
public class TestAutoBean extends UnitTestBase {
	
	public TestAutoBean() {
		super("classpath*:spring-annoioc1.xml");
		//super("classpath*:spring-autoioc.xml");
	}
	
	@Test
	public void test1() {
		//muma 因为 exclude 所以没有被注册成Spring bean
		Child child = super.getBean("child");
		System.out.println("child:>>>"+child);
		System.out.println(child.play());

	}

	@Test
	public void test2() {
		Zooker zooker = super.getBean("zooker");
		System.out.println(zooker.action());
	}

	@Test
	public void test3() {
		Car car = super.getBean("car");
		System.out.println(car.drive());
	}


}
