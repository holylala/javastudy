/**
 * 
 */
package com.huang.test;

import com.huang.autoiocmore.Child;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;


/**   
 * @Title: TestBean.java 
 * @Package com.huang.test 
 * @Description: 
 * @Copyright： Copyright(c)2015
 * @Company：Bjrun 
 * @author zhenqiong zhenqiong@run.com   
 * @date 2015-12-4 下午03:51:53 
 * @version V1.0   
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestAutoBean extends UnitTestBase {
	
	public TestAutoBean() {
		super("classpath*:spring-annoioc1.xml");
	}
	
	@Test
	public void test1() {
		
		Child child = super.getBean("child");
		System.out.println("child:>>>"+child);
		System.out.println(child.play());
	}
	
}
